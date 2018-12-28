import 'package:flutter/material.dart';
import 'TabBarWidget.dart';

void main() {
  runApp(MYS());
}

class MYS extends StatefulWidget {
  @override
  _MYSState createState() => _MYSState();
}

final List<Color> _colors = [
  Colors.blue,
  Colors.green,
  Colors.pink,
  Colors.yellow,
  Colors.red,
  Colors.purple,
  Colors.orange,
];
int _a;
class _MYSState extends State<MYS> with SingleTickerProviderStateMixin {
  TabController _mysTabController;
  Color _color;
  @override
  void initState() {
    _a??=0;
    _color ??= _colors[0]; //设置一个颜色的初始值
    _mysTabController = TabController(vsync: this, length: 6,initialIndex: _a);
    super.initState();
    _mysTabController.animation.addListener(() {
      setState(() {
        _a=_mysTabController.index;
        if (_mysTabController.offset > 0) {
          //当Tab向右滑动时
          final ColorTween myscolor = ColorTween(
            begin: _colors[_mysTabController.index],
            end: _colors[_mysTabController.index + 1],
          );
          _color = myscolor.lerp(_mysTabController.offset);
        }
        if (_mysTabController.offset < 0) {
          //当Tab向左滑动时
          final ColorTween myscolor = ColorTween(
            begin: _colors[_mysTabController.index],
            end: _colors[_mysTabController.index - 1],
          );
          _color = myscolor.lerp(-_mysTabController.offset);
        }
        //print(_mysTabController.offset);
      });
    });
  }

  @override
  void dispose() {
    _mysTabController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: _color,
        title: Text("MYSTabColur"),
        bottom: TabBar(
          controller: _mysTabController,
          tabs: <Widget>[
            Tab(
              text: "一",
            ),
            Tab(
              text: "二",
            ),
            Tab(
              text: "三",
            ),
            Tab(
              text: "四",
            ),
            Tab(
              text: "五",
            ),
            Tab(
              text: "六",
            ),
          ],
        ),
      ),
      body: TabBarView(
        controller: _mysTabController,
        children: <Widget>[
          Container(
            child: Center(
              child: Text("MYScolor"),
            ),
          ),
          Container(
            child: Center(
              child: Text("MYScolor"),
            ),
          ),
          Container(
            child: Center(
              child: Text("MYScolor"),
            ),
          ),
          Container(
            child: Center(
              child: Text("MYScolor"),
            ),
          ),
          Container(
            child: Center(
              child: Text("MYScolor"),
            ),
          ),
          Container(
            child: Center(
              child: Text("MYScolor"),
            ),
          ),
        ],
      ),
    );
  }
}
