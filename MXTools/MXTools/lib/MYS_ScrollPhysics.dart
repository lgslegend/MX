import 'package:flutter/material.dart';
import 'dart:math' as math;

class MYS_ScrollPhysics extends ScrollPhysics {
  /// Creates scroll physics that prevent the scroll offset from exceeding the
  /// bounds of the content..
  const MYS_ScrollPhysics({ ScrollPhysics parent }) : super(parent: parent);

  @override
  MYS_ScrollPhysics applyTo(ScrollPhysics ancestor) {
    return MYS_ScrollPhysics(parent: buildParent(ancestor));
  }

  @override
  double applyBoundaryConditions(ScrollMetrics position, double value) {
    assert(() {
      if (value == position.pixels) {
        throw FlutterError(
          '$runtimeType.applyBoundaryConditions() was called redundantly.\n'
          'The proposed new position, $value, is exactly equal to the current position of the '
          'given ${position.runtimeType}, ${position.pixels}.\n'
          'The applyBoundaryConditions method should only be called when the value is '
          'going to actually change the pixels, otherwise it is redundant.\n'
          'The physics object in question was:\n'
          '  $this\n'
          'The position object in question was:\n'
          '  $position\n'
        );
      }
      return true;
    }());
    if (value < position.pixels && position.pixels <= position.minScrollExtent) // underscroll
      return value - position.pixels;
      //print("你拉过了");
    if (position.maxScrollExtent <= position.pixels && position.pixels < value) // overscroll
      return value - position.pixels;
      //print("你拉过了");
    if (value < position.minScrollExtent && position.minScrollExtent < position.pixels) // hit top edge
    
      return value - position.minScrollExtent;
      
     //print("你拉过了");
    if (position.pixels < position.maxScrollExtent && position.maxScrollExtent < value) // hit bottom edge
    
      return value - position.maxScrollExtent;
      //print("你拉过了");
    return 0.0;
  }

  @override
  Simulation createBallisticSimulation(ScrollMetrics position, double velocity) {
    
    final Tolerance tolerance = this.tolerance;
    if (position.outOfRange) {
      print("你拉过了");
      double end;
      if (position.pixels > position.maxScrollExtent)
      
      print("你拉过了");
        end = position.maxScrollExtent;
      if (position.pixels < position.minScrollExtent)
        end = position.minScrollExtent;
      assert(end != null);
      return ScrollSpringSimulation(
        spring,
        position.pixels,
        end,
        math.min(0.0, velocity),
        tolerance: tolerance
      );
    }
    if (velocity.abs() < tolerance.velocity)
      return null;
    if (velocity > 0.0 && position.pixels >= position.maxScrollExtent)
      return null;
    if (velocity < 0.0 && position.pixels <= position.minScrollExtent)
      return null;
    return ClampingScrollSimulation(
      position: position.pixels,
      velocity: velocity,
      tolerance: tolerance,
    );
  }
}