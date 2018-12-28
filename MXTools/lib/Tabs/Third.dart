import 'dart:async';

import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

int thirdPage;
double a;

class Third extends StatefulWidget {
  @override
  _ThirdState createState() => _ThirdState();
}

class _ThirdState extends State<Third> with SingleTickerProviderStateMixin {
  static final platform = const MethodChannel("Third");
  static final DPI = const EventChannel('Third3');
  static const platform0 = const MethodChannel("Linux");
  static const platform1 = const MethodChannel("Toast");
  StreamSubscription _subscription = null;
  AnimationController animationController;
  Animation<EdgeInsets> movement;
  String _DPI;
  final TextEditingController _textcontroller0 = new TextEditingController();
  final TextEditingController _textcontroller1 = new TextEditingController();
  final TextEditingController _textcontroller2 = new TextEditingController();
  @override
  void initState() {
    super.initState();
    DPITOOL();
    thirdPage ??= 0;
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
    //_textcontroller.text ??= "$_DPI";
  }

  Future<Null> _dialog(String title, String text0) async {
    return showDialog<Null>(
      context: context,
      barrierDismissible: true, // user must tap button!
      builder: (BuildContext context) {
        return AlertDialog(
          title: Text(
            title,
            style: TextStyle(
              fontSize: 20.0,
              fontWeight: FontWeight.bold,
            ),
          ),
          content: Container(
            height: 154,
            child: Column(
              children: <Widget>[
                Align(
                  alignment: Alignment.centerLeft,
                  child: Text(
                    "DPI",
                    style: TextStyle(
                      color: Color(0x90303030),
                      fontSize: 16.0,
                    ),
                  ),
                ),
                TextField(
                  controller: _textcontroller0,
                  keyboardType: TextInputType.text,
                  // decoration: new InputDecoration(
                  //   contentPadding: const EdgeInsets.only(top: 10.0),
                  //   helperText: text,
                  // ),
                  autofocus: false,
                ),
                Padding(
                  padding: EdgeInsets.fromLTRB(0, 20, 0, 0),
                  child: Align(
                    alignment: Alignment.centerLeft,
                    child: Text(
                      "分辨率",
                      style: TextStyle(
                        color: Color(0x90303030),
                        fontSize: 16.0,
                      ),
                    ),
                  ),
                ),
                Row(
                  children: <Widget>[
                    SizedBox(
                      width: 60,
                      child: TextField(
                        controller: _textcontroller1,
                        keyboardType: TextInputType.text,
                        // decoration: new InputDecoration(
                        //   contentPadding: const EdgeInsets.only(top: 10.0),
                        //   helperText: text,
                        // ),
                        autofocus: false,
                      ),
                    ),
                    Text("x"),
                    SizedBox(
                      width: 60,
                      child: TextField(
                        controller: _textcontroller2,
                        keyboardType: TextInputType.text,
                        // decoration: new InputDecoration(
                        //   contentPadding: const EdgeInsets.only(top: 10.0),
                        //   helperText: text,
                        // ),
                        autofocus: false,
                      ),
                    ),
                  ],
                )
              ],
            ),
          ),
          actions: <Widget>[
            FlatButton(
              child: Text(
                '取消',
                style: TextStyle(
                  fontSize: 14.0,
                  fontWeight: FontWeight.bold,
                ),
              ),
              onPressed: () {
                Navigator.of(context).pop();
              },
            ),
            FlatButton(
              child: Text(
                '确认修改',
                style: TextStyle(
                  fontSize: 14.0,
                  fontWeight: FontWeight.bold,
                ),
              ),
              onPressed: () {
                platform0.invokeMethod("mount -o rw,remount /system\n" +
                    "wm density reset\n" +
                    "wm density " +
                    _textcontroller0.text +
                    "\n");
                platform1.invokeMethod("1秒钟就好");
                Navigator.of(context).pop();
                Future.delayed(Duration(milliseconds: 2000), () {
                  setState(() {
                    _subscription = DPI
                        .receiveBroadcastStream()
                        .listen(_onEvent, onError: _onError);
                  });
                });
              },
            ),
          ],
        );
      },
    );
  }

  Future<Null> DPITOOL() async {
    _DPI ??= "识别中.........";
    if (_subscription == null) {
      _subscription =
          DPI.receiveBroadcastStream().listen(_onEvent, onError: _onError);
    }
  }

  void _onError(Object error) {
    setState(() {
      _DPI = "识别失败";
    });
  }

  void _onEvent(Object event) {
    setState(() {
      _DPI = event;
    });
  }

  Future<Null> _handleRefresh() async {
    await Future.delayed(Duration(seconds: 0), () {
      setState(() {});
    });
  }

  @override
  void dispose() {
    if (_subscription != null) {
      _subscription.cancel();
    }
    animationController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return _thirdPage();
  }

  _thirdPage() {
    if (thirdPage == 0) {
      return RefreshIndicator(
        child: ListView(
          children: <Widget>[
            Padding(
              padding: movement.value - EdgeInsets.fromLTRB(8.0, 8.0, 0.0, 0.0),
            ),
            Card(
              elevation: 1,
              child: InkWell(
                borderRadius: BorderRadius.circular(4.0),
                onTap: () {
                  setState(() {});
                },
                child: SizedBox(
                  width: MediaQuery.of(context).size.width,
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: <Widget>[
                      Padding(
                        padding: movement.value,
                        child: Text(
                          "CPU设置",
                          style: TextStyle(
                            fontSize: 14.0,
                            fontWeight: FontWeight.bold,
                          ),
                        ),
                      ),
                      Padding(
                        padding: const EdgeInsets.fromLTRB(8.0, 4.0, 0.0, 8.0),
                        child: Text(
                          "调整手机CPU各种配置",
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
                          "自定义DPI，屏幕分辨率",
                          style: TextStyle(
                            fontSize: 14.0,
                            fontWeight: FontWeight.bold,
                          ),
                        ),
                      ),
                      Padding(
                        padding: const EdgeInsets.fromLTRB(8.0, 4.0, 0.0, 8.0),
                        child: Text(
                          "当前DPI为：" +
                              _DPI.substring(0, 3) +
                              "    当前分辨率为：" +
                              _DPI.substring(3, 7) +
                              "x" +
                              _DPI.substring(7, 11),
                          style: TextStyle(
                            color: Color(0xff696666),
                            fontSize: 12.0,
                          ),
                        ),
                      ),
                    ],
                  ),
                ),
                onTap: () {
                  setState(() {
                    _textcontroller0.text = _DPI.substring(0, 3);
                    _textcontroller1.text = _DPI.substring(3, 7);
                    _textcontroller2.text = _DPI.substring(7, 11);
                    _dialog("修改你的DPI，屏幕分辨率", "");
                  });
                },
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
                          "机型修改",
                          style: TextStyle(
                            fontSize: 14.0,
                            fontWeight: FontWeight.bold,
                          ),
                        ),
                      ),
                      Padding(
                        padding: const EdgeInsets.fromLTRB(8.0, 4.0, 0.0, 8.0),
                        child: Text(
                          "修改手机型号",
                          style: TextStyle(
                            color: Color(0xff696666),
                            fontSize: 12.0,
                          ),
                        ),
                      ),
                    ],
                  ),
                ),
                onTap: () {
                  setState(() {
                    thirdPage = 3;
                  });
                },
              ),
            ),
          ],
        ),
        onRefresh: (_handleRefresh),
      );
    }
    if (thirdPage == 3) {
      return WillPopScope(
          child: Third3(),
          onWillPop: () {
            setState(() {
              thirdPage = 0;
            });
          });
    }
  }
}
class Third3 extends StatefulWidget {
  @override
  _Third3State createState() => _Third3State();
}

class _Third3State extends State<Third3> with SingleTickerProviderStateMixin {
  AnimationController animationController;
  Animation<EdgeInsets> movement;
  static const XingHao = const EventChannel('Third3/XingHao');
  StreamSubscription _subscription1 = null;
  String _XingHao;
  final TextEditingController _textcontroller = new TextEditingController();
  @override
  void initState() {
    super.initState();
    JiXingXiuGai();
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

  Future<Null> JiXingXiuGai() async {
    _XingHao ??= "识别中...                                                    ";
    if (_subscription1 == null) {
      _subscription1 =
          XingHao.receiveBroadcastStream().listen(_onEvent1, onError: _onError);
    }
  }

  void _onError(Object error) {
    setState(() {
      _XingHao = "识别失败";
    });
  }

  void _onEvent1(Object event) {
    setState(() {
      _XingHao = event;
    });
  }


  @override
  void dispose() {
    if (_subscription1 != null) {
      _subscription1.cancel();
    }
    animationController.dispose();
    super.dispose();
  }

  Future<Null> _dialog(String title, String text) async {
    return showDialog<Null>(
      context: context,
      barrierDismissible: true, // user must tap button!
      builder: (BuildContext context) {
        return AlertDialog(

          title: Text(

            title,
            style: TextStyle(
              fontSize: 20.0,
              fontWeight: FontWeight.bold,
            ),
          ),
          content: new TextField(
            controller: _textcontroller,
            keyboardType: TextInputType.number,
            decoration: new InputDecoration(
              contentPadding: const EdgeInsets.only(top: 10.0),
              helperText: text,
            ),
            autofocus: false,
          ),
          actions: <Widget>[
            FlatButton(
              child: Text(
                '取消',
                style: TextStyle(
                  fontSize: 14.0,
                  fontWeight: FontWeight.bold,
                ),
              ),
              onPressed: () {
                Navigator.of(context).pop();
              },
            ),FlatButton(
              child: Text(
                '确认修改',
                style: TextStyle(
                  fontSize: 14.0,
                  fontWeight: FontWeight.bold,
                ),
              ),
              onPressed: () {
                Navigator.of(context).pop();
              },
            ),
          ],
        );
      },
    );
  }

  @override
  Widget build(BuildContext context) {
    return new ListView(
      children: <Widget>[
        Padding(
          padding: movement.value - EdgeInsets.fromLTRB(8.0, 8.0, 0.0, 0.0),
        ),
        Padding(
          padding: movement.value - EdgeInsets.fromLTRB(8.0, 8.0, 0.0, 0.0),
          child: Text(
            "机型设置",
            style: TextStyle(
              color: Color(0x90303030),
              fontSize: 14.0,
            ),
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
                      "修改型号(ro.product.model)",
                      style: TextStyle(
                        fontSize: 14.0,
                        fontWeight: FontWeight.bold,
                      ),
                    ),
                  ),
                  Padding(
                    padding: const EdgeInsets.fromLTRB(8.0, 4.0, 0.0, 8.0),
                    child: Text(
                      "当前为："+_XingHao.substring(0,9),
                      style: TextStyle(
                        color: Color(0xff696666),
                        fontSize: 12.0,
                      ),
                    ),
                  ),
                ],
              ),
            ),
            onTap: () {
              _textcontroller.text=_XingHao.substring(0,9);
              _dialog("修改你的手机型号", "当前为："+_XingHao.substring(0,9),);
            },
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
                      "修改厂商名称(ro.product.manufacturer)",
                      style: TextStyle(
                        fontSize: 14.0,
                        fontWeight: FontWeight.bold,
                      ),
                    ),
                  ),
                  Padding(
                    padding: const EdgeInsets.fromLTRB(8.0, 4.0, 0.0, 8.0),
                    child: Text(
                      "当前为："+_XingHao.substring(9,15),
                      style: TextStyle(
                        color: Color(0xff696666),
                        fontSize: 12.0,
                      ),
                    ),
                  ),
                ],
              ),
            ),
            onTap: () {
              _textcontroller.text=_XingHao.substring(9,15);
              _dialog("修改你的厂商名称", "当前为："+_XingHao.substring(9,15),);
            },
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
                      "开启王者录像",
                      style: TextStyle(
                        fontSize: 14.0,
                        fontWeight: FontWeight.bold,
                      ),
                    ),
                  ),
                  Padding(
                    padding: const EdgeInsets.fromLTRB(8.0, 4.0, 0.0, 8.0),
                    child: Text(
                      "点击修改为小米8Lite",
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
        ),
        Padding(
          padding: movement.value - EdgeInsets.fromLTRB(8.0, 8.0, 0.0, 0.0),
          child: Text(
            "其他值",
            style: TextStyle(
              color: Color(0x90303030),
              fontSize: 14.0,
            ),
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
                      "修改品牌名称（ro.product.brand）",
                      style: TextStyle(
                        fontSize: 14.0,
                        fontWeight: FontWeight.bold,
                      ),
                    ),
                  ),
                  Padding(
                    padding: const EdgeInsets.fromLTRB(8.0, 4.0, 0.0, 8.0),
                    child: Text(
                      "当前为："+_XingHao.substring(15,21),
                      style: TextStyle(
                        color: Color(0xff696666),
                        fontSize: 12.0,
                      ),
                    ),
                  ),
                ],
              ),
            ),
            onTap: () {
              _textcontroller.text=_XingHao.substring(15,21);
              _dialog("修改你的品牌名称", "当前为："+_XingHao.substring(15,21),);
            },
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
                      "修改设备标记（ro.product.name）",
                      style: TextStyle(
                        fontSize: 14.0,
                        fontWeight: FontWeight.bold,
                      ),
                    ),
                  ),
                  Padding(
                    padding: const EdgeInsets.fromLTRB(8.0, 4.0, 0.0, 8.0),
                    child: Text(
                      "当前为："+_XingHao.substring(21,28),
                      style: TextStyle(
                        color: Color(0xff696666),
                        fontSize: 12.0,
                      ),
                    ),
                  ),
                ],
              ),
            ),
            onTap: () {
              _textcontroller.text=_XingHao.substring(21,28);
              _dialog("修改你的设备标记", "当前为："+_XingHao.substring(21,28),);
            },
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
                      "修改版本ID（ro.build.id）",
                      style: TextStyle(
                        fontSize: 14.0,
                        fontWeight: FontWeight.bold,
                      ),
                    ),
                  ),
                  Padding(
                    padding: const EdgeInsets.fromLTRB(8.0, 4.0, 0.0, 8.0),
                    child: Text(
                      "当前为："+_XingHao.substring(28,43),
                      style: TextStyle(
                        color: Color(0xff696666),
                        fontSize: 12.0,
                      ),
                    ),
                  ),
                ],
              ),
            ),
            onTap: () {
              _textcontroller.text=_XingHao.substring(28,43);
              _dialog("修改你的版本ID", "当前为："+_XingHao.substring(28,43),);
            },
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
                      "修改版本号（ro.build.display.id）",
                      style: TextStyle(
                        fontSize: 14.0,
                        fontWeight: FontWeight.bold,
                      ),
                    ),
                  ),
                  Padding(
                    padding: const EdgeInsets.fromLTRB(8.0, 4.0, 0.0, 8.0),
                    child: Text(
                      "当前为："+_XingHao.substring(43,58),
                      style: TextStyle(
                        color: Color(0xff696666),
                        fontSize: 12.0,
                      ),
                    ),
                  ),
                ],
              ),
            ),
            onTap: () {
              _textcontroller.text=_XingHao.substring(43,58);
              _dialog("修改你的版本号", "当前为："+_XingHao.substring(43,58),);
            },
          ),
        ),
        Card(
          elevation: 1,
          child: InkWell(
            borderRadius: BorderRadius.circular(4.0),
            child: SizedBox(
              height: 52,
              width: MediaQuery.of(context).size.width,
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: <Widget>[
                  Padding(
                    padding: movement.value +
                        EdgeInsets.fromLTRB(0.0, 8.0, 0.0, 0.0),
                    child: Text(
                      "恢复默认值",
                      style: TextStyle(
                        fontSize: 14.0,
                        fontWeight: FontWeight.bold,
                      ),
                    ),
                  ),
                ],
              ),
            ),
            onTap: () => {},
          ),
        ),
        Align(
          alignment: Alignment.bottomCenter,
          child: Center(
            child: Text(
              "提示：已生成的系统信息单刷备份包位于Sdcard/Nightmare ",
              style: TextStyle(
                color: Color(0xff000000),
                fontSize: 14.0,
              ),
            ),
          ),
        )
      ],
    );
  }
}
