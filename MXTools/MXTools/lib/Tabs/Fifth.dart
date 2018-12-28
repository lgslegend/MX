import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

class Fifth extends StatefulWidget {
  @override
  _FifthState createState() => _FifthState();
}

class _FifthState extends State<Fifth> with SingleTickerProviderStateMixin {
  AnimationController animationController;
  Animation<EdgeInsets> movement;

  static const platform = const MethodChannel("Fourth/Brevent");

  @override
  void initState() {
    super.initState();
    animationController = new AnimationController(
        duration: const Duration(milliseconds: 800), vsync: this);
    final Animation curve =
        CurvedAnimation(parent: animationController, curve: Curves.ease);
    movement = EdgeInsetsTween(
      begin: const EdgeInsets.fromLTRB(8.0, 1000, 0.0, 0.0),
      end: const EdgeInsets.fromLTRB(8.0, 8.0, 0.0, 0.0),
    ).animate(curve);
    movement.addListener(() {
      setState(() {
        // the state that has changed here is the animation object’s value
      });
    });
    animationController.forward();
  }

  @override
  void dispose() {
    animationController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return new ListView(
      children: <Widget>[
        Padding(
          padding: movement.value - EdgeInsets.fromLTRB(8.0, 8.0, 0.0, 0.0),
        ),
        Card(
          elevation: 1,
          child: InkWell(
            borderRadius: BorderRadius.circular(4.0),
            child: SizedBox(
              width: MediaQuery.of(context).size.width,
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: <Widget>[
                  Padding(
                    padding: movement.value,
                    child: Text(
                      "开发者选项",
                      style: TextStyle(
                        fontSize: 14.0,
                        fontWeight: FontWeight.bold,
                      ),
                    ),
                  ),
                  Padding(
                    padding: const EdgeInsets.fromLTRB(8.0, 4.0, 0.0, 8.0),
                    child: Text(
                      "进入开发者选项（无需点击三次系统版本）",
                      style: TextStyle(
                        color: Color(0xff696666),
                        fontSize: 12.0,
                      ),
                    ),
                  ),
                ],
              ),
            ),
            onTap: () => {},
          ),
        ),
        Card(
          elevation: 1,
          child: InkWell(
            borderRadius: BorderRadius.circular(4.0),
            child: SizedBox(
              width: MediaQuery.of(context).size.width,
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: <Widget>[
                  Padding(
                    padding: movement.value,
                    child: Text(
                      "测试模式",
                      style: TextStyle(
                        fontSize: 14.0,
                        fontWeight: FontWeight.bold,
                      ),
                    ),
                  ),
                  Padding(
                    padding: const EdgeInsets.fromLTRB(8.0, 4.0, 0.0, 8.0),
                    child: Text(
                      "*#*#4636#*#*",
                      style: TextStyle(
                        color: Color(0xff696666),
                        fontSize: 12.0,
                      ),
                    ),
                  ),
                ],
              ),
            ),
            onTap: () => {},
          ),
        ),
      ],
    );
  }
}
