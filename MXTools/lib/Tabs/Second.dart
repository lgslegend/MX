import 'package:flutter/material.dart';

class Second extends StatefulWidget {
  @override
  _SecondState createState() => _SecondState();
}

class _SecondState extends State<Second> with SingleTickerProviderStateMixin {
  AnimationController animationController;
  Animation<EdgeInsets> movement;

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

  Future<Null> _handleRefresh() async {
    await Future.delayed(Duration(seconds: 0), () {
      setState(() {});
    });
  }

  @override
  void dispose() {
    animationController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return RefreshIndicator(
      child: ListView(
        children: <Widget>[
          InkWell(
            onTap: () => {},
            child: SizedBox(
              width: MediaQuery.of(context).size.width,
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: <Widget>[
                  Padding(
                    padding: movement.value,
                    child: Text(
                      "Xposed框架管理",
                      style: TextStyle(
                        fontSize: 14.0,
                        fontWeight: FontWeight.bold,
                      ),
                    ),
                  ),
                  Padding(
                    padding: const EdgeInsets.fromLTRB(8.0, 4.0, 0.0, 8.0),
                    child: Text(
                      "点击打开Xposed框架",
                      style: TextStyle(
                        color: Color(0xff696666),
                        fontSize: 12.0,
                      ),
                    ),
                  ),
                ],
              ),
            ),
          ),
          InkWell(
            onTap: () => {},
            child: SizedBox(
              width: MediaQuery.of(context).size.width,
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: <Widget>[
                  Padding(
                    padding: movement.value,
                    child: Text(
                      "沉浸式状态栏",
                      style: TextStyle(
                        fontSize: 14.0,
                        fontWeight: FontWeight.bold,
                      ),
                    ),
                  ),
                  Padding(
                    padding: const EdgeInsets.fromLTRB(8.0, 4.0, 0.0, 8.0),
                    child: Text(
                      "沉浸式状态栏设置",
                      style: TextStyle(
                        color: Color(0xff696666),
                        fontSize: 12.0,
                      ),
                    ),
                  ),
                ],
              ),
            ),
          ),
          InkWell(
            onTap: () => {},
            child: SizedBox(
              width: MediaQuery.of(context).size.width,
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: <Widget>[
                  Padding(
                    padding: movement.value,
                    child: Text(
                      "QQ抢红包",
                      style: TextStyle(
                        fontSize: 14.0,
                        fontWeight: FontWeight.bold,
                      ),
                    ),
                  ),
                  Padding(
                    padding: const EdgeInsets.fromLTRB(8.0, 4.0, 0.0, 8.0),
                    child: Text(
                      "QQ抢红包设置",
                      style: TextStyle(
                        color: Color(0xff696666),
                        fontSize: 12.0,
                      ),
                    ),
                  ),
                ],
              ),
            ),
          ),
          InkWell(
            onTap: () => {},
            child: SizedBox(
              width: MediaQuery.of(context).size.width,
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: <Widget>[
                  Padding(
                    padding: movement.value,
                    child: Text(
                      "微信抢红包",
                      style: TextStyle(
                        fontSize: 14.0,
                        fontWeight: FontWeight.bold,
                      ),
                    ),
                  ),
                  Padding(
                    padding: const EdgeInsets.fromLTRB(8.0, 4.0, 0.0, 8.0),
                    child: Text(
                      "微信抢红包设置",
                      style: TextStyle(
                        color: Color(0xff696666),
                        fontSize: 12.0,
                      ),
                    ),
                  ),
                ],
              ),
            ),
          ),
          InkWell(
            onTap: () => {},
            child: SizedBox(
              width: MediaQuery.of(context).size.width,
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: <Widget>[
                  Padding(
                    padding: movement.value,
                    child: Text(
                      "QX模块",
                      style: TextStyle(
                        fontSize: 14.0,
                        fontWeight: FontWeight.bold,
                      ),
                    ),
                  ),
                  Padding(
                    padding: const EdgeInsets.fromLTRB(8.0, 4.0, 0.0, 8.0),
                    child: Text(
                      "QX模块设置",
                      style: TextStyle(
                        color: Color(0xff696666),
                        fontSize: 12.0,
                      ),
                    ),
                  ),
                ],
              ),
            ),
          ),
          InkWell(
            onTap: () => {},
            child: SizedBox(
              width: MediaQuery.of(context).size.width,
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: <Widget>[
                  Padding(
                    padding: movement.value,
                    child: Text(
                      "窗口多任务",
                      style: TextStyle(
                        fontSize: 14.0,
                        fontWeight: FontWeight.bold,
                      ),
                    ),
                  ),
                  Padding(
                    padding: const EdgeInsets.fromLTRB(8.0, 4.0, 0.0, 8.0),
                    child: Text(
                      "实现程序窗口化",
                      style: TextStyle(
                        color: Color(0xff696666),
                        fontSize: 12.0,
                      ),
                    ),
                  ),
                ],
              ),
            ),
          ),
          InkWell(
            onTap: () => {},
            child: SizedBox(
              width: MediaQuery.of(context).size.width,
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: <Widget>[
                  Padding(
                    padding: movement.value,
                    child: Text(
                      "文本自定义",
                      style: TextStyle(
                        fontSize: 14.0,
                        fontWeight: FontWeight.bold,
                      ),
                    ),
                  ),
                  Padding(
                    padding: const EdgeInsets.fromLTRB(8.0, 4.0, 0.0, 8.0),
                    child: Text(
                      "文本自定义设置",
                      style: TextStyle(
                        color: Color(0xff696666),
                        fontSize: 12.0,
                      ),
                    ),
                  ),
                ],
              ),
            ),
          ),
          InkWell(
            onTap: () => {},
            child: SizedBox(
              width: MediaQuery.of(context).size.width,
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: <Widget>[
                  Padding(
                    padding: movement.value,
                    child: Text(
                      "型号伪装",
                      style: TextStyle(
                        fontSize: 14.0,
                        fontWeight: FontWeight.bold,
                      ),
                    ),
                  ),
                  Padding(
                    padding: const EdgeInsets.fromLTRB(8.0, 4.0, 0.0, 8.0),
                    child: Text(
                      "改变单个应用读取到的手机型号",
                      style: TextStyle(
                        color: Color(0xff696666),
                        fontSize: 12.0,
                      ),
                    ),
                  ),
                ],
              ),
            ),
          ),
        ],
      ),
      onRefresh: (_handleRefresh),
    );
  }
}
