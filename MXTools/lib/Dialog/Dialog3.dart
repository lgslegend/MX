import 'package:flutter/material.dart';
import 'AlertDialogBuilder.dart';
import 'package:mx/main.dart';

class Dialog3 extends StatefulWidget {
  @override
  State<StatefulWidget> createState() => Dialog3State();
}

class Dialog3State extends State<Dialog3> with SingleTickerProviderStateMixin {
  AnimationController dialoganimation;
  Animation<EdgeInsets> dialog;
  @override
  void initState() {
    super.initState();
    dialoganimation = new AnimationController(
        duration: const Duration(milliseconds: 800), vsync: this);
    final Animation curve2 =
        CurvedAnimation(parent: dialoganimation, curve: Curves.bounceOut);
    dialog = EdgeInsetsTween(
      begin: const EdgeInsets.fromLTRB(0, 1000, 0, 0),
      end: const EdgeInsets.fromLTRB(0, 0, 0, 0),
    ).animate(curve2);
    dialog.addListener(() {
      setState(() {
        print(dialoganimation.value);
        // the state that has changed here is the animation object’s value
      });
    });
    dialoganimation.forward();
  }

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: dialog.value,
      child: AlertDialogBuilder(

        content: Container(
          width: 500,
          height: 600,
          child: Nightmare(),
        )
      ),
    );
  }
}
