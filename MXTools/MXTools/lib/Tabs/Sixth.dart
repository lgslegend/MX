import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

class Sixth extends StatefulWidget {
  @override
  _SixthState createState() => _SixthState();
}

class _SixthState extends State<Sixth> with SingleTickerProviderStateMixin {
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

  bool bval = false;

  void method1(value) {
    setState(() {
      bval = value;
    });
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
            child: Container(
              alignment: Alignment.centerRight,
              height: 52,
              width: MediaQuery.of(context).size.width,
              child: Row(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: <Widget>[
                  Padding(
                    padding: movement.value +
                        EdgeInsets.fromLTRB(0.0, 8.0, 0.0, 0.0),
                    child: Text(
                      "恢复官方应用商店",
                      style: TextStyle(
                        fontSize: 14.0,
                        fontWeight: FontWeight.bold,
                      ),
                    ),
                  ),
                  Switch(
                    value: bval,
                    onChanged: (bool val) {
                      method1(val);
                    },
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
            child: Container(
              alignment: Alignment.centerRight,
              height: 52,
              width: MediaQuery.of(context).size.width,
              child: Row(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: <Widget>[
                  Padding(
                    padding: movement.value +
                        EdgeInsets.fromLTRB(0.0, 8.0, 0.0, 0.0),
                    child: Text(
                      "适度精简系统",
                      style: TextStyle(
                        fontSize: 14.0,
                        fontWeight: FontWeight.bold,
                      ),
                    ),
                  ),
                  Switch(
                    value: bval,
                    onChanged: (bool val) {
                      method1(val);
                    },
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
            child: Container(
              alignment: Alignment.centerRight,
              height: 52,
              width: MediaQuery.of(context).size.width,
              child: Row(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: <Widget>[
                  Padding(
                    padding: movement.value +
                        EdgeInsets.fromLTRB(0.0, 8.0, 0.0, 0.0),
                    child: Text(
                      "极限精简系统",
                      style: TextStyle(
                        fontSize: 14.0,
                        fontWeight: FontWeight.bold,
                      ),
                    ),
                  ),
                  Switch(
                    value: bval,
                    onChanged: (bool val) {
                      method1(val);
                    },
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
                      "自定义精简",
                      style: TextStyle(
                        fontSize: 14.0,
                        fontWeight: FontWeight.bold,
                      ),
                    ),
                  ),
                  Padding(
                    padding: const EdgeInsets.fromLTRB(8.0, 4.0, 0.0, 8.0),
                    child: Text(
                      "选择要删除的系统应用",
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
