import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'package:flutter/animation.dart';

int firstPage;

class First extends StatefulWidget {
  @override
  _FirstState createState() => _FirstState();
}

class _FirstState extends State<First> with SingleTickerProviderStateMixin {
  static const platform = const MethodChannel("Toast");
  int ToastNumber;
  AnimationController animationController;
  Animation<EdgeInsets> movement;
  @override
  void initState() {
    
    super.initState();
    firstPage ??= 0;

    animationController = new AnimationController(
        duration: const Duration(milliseconds: 800), vsync: this);
    final Animation curve =
        CurvedAnimation(parent: animationController, curve: Curves.ease);
    movement = EdgeInsetsTween(
      begin: const EdgeInsets.fromLTRB(8.0, 1000, 0.0, 0.0),
      end: const EdgeInsets.fromLTRB(8.0, 8.0, 0.0, 0.0),
    ).animate(curve);
    movement.addListener(() {
      setState(() {});
    });
    start();
  }

  @override
  void dispose() {
    super.dispose();
  }

  void start() {
    animationController.forward();
  }

  Future<Null> _handleRefresh() async {
    ToastNumber ??= 0;
    if (ToastNumber == 0) {
      await Future.delayed(Duration(seconds: 0), () {
        print("\$\1");
        platform.invokeMethod("啥也没有");
        setState(() {
        ToastNumber++;
        });
      });
    }else{
    if (ToastNumber == 1) {
      await Future.delayed(Duration(seconds: 0), () {
        platform.invokeMethod("说了啥也没有");
        ToastNumber++;
        setState(() {});
      });
    }else{
      if (ToastNumber == 2) {
      await Future.delayed(Duration(seconds: 0), () {
        platform.invokeMethod("别拉了");
        ToastNumber++;
        setState(() {});
      });
    }else{
      await Future.delayed(Duration(seconds: 0), () {
        Scaffold.of(context).showSnackBar(SnackBar(
          content: Text("给你一手SnackBar"),
        ));
        
        setState(() {});
      });
    }
    }
    
    }
  }

  @override
  Widget build(BuildContext context) {
    return _firstPage();
  }

   _firstPage() {
    if (firstPage == 0) {
      return RefreshIndicator(
        displacement: 8,
        child: ListView(
          physics: const AlwaysScrollableScrollPhysics(),
          children: <Widget>[
            Padding(
              padding: movement.value - EdgeInsets.fromLTRB(8.0, 8.0, 0.0, 0.0),
            ),
            Card(
              elevation: 1,
              child: InkWell(
                borderRadius: BorderRadius.circular(4.0),
                onTap: () {
                  setState(() {
                    firstPage = 1;
                  });
                },
                child: SizedBox(
                  width: MediaQuery.of(context).size.width,
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: <Widget>[
                      Padding(
                        padding: movement.value,
                        child: Text(
                          "状态栏布局",
                          style: TextStyle(
                            fontSize: 14.0,
                            fontWeight: FontWeight.bold,
                          ),
                        ),
                      ),
                      Padding(
                        padding: const EdgeInsets.fromLTRB(8.0, 4.0, 0.0, 8.0),
                        child: Text(
                          "IOS布局，官方布局切换",
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
              child: InkWell(
                borderRadius: BorderRadius.circular(4.0),
                onTap: () {
                  setState(() {
                    firstPage = 2;
                  });
                },
                child: SizedBox(
                  width: MediaQuery.of(context).size.width,
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: <Widget>[
                      Padding(
                        padding: movement.value,
                        child: Text(
                          "状态栏时间风格",
                          style: TextStyle(
                            fontSize: 14.0,
                            fontWeight: FontWeight.bold,
                          ),
                        ),
                      ),
                      Padding(
                        padding: const EdgeInsets.fromLTRB(8.0, 4.0, 0.0, 8.0),
                        child: Text(
                          "显示农历，星期，时间",
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
              child: InkWell(
                borderRadius: BorderRadius.circular(4.0),
                onTap: () {
                  setState(() {
                    firstPage = 3;
                  });
                },
                child: SizedBox(
                  width: MediaQuery.of(context).size.width,
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: <Widget>[
                      Padding(
                        padding: movement.value,
                        child: Text(
                          "桌面图标布局",
                          style: TextStyle(
                            fontSize: 14.0,
                            fontWeight: FontWeight.bold,
                          ),
                        ),
                      ),
                      Padding(
                        padding: const EdgeInsets.fromLTRB(8.0, 4.0, 0.0, 8.0),
                        child: Text(
                          "桌面4x5，4x6，5x5，5x6切换",
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
              child: InkWell(
                borderRadius: BorderRadius.circular(4.0),
                onTap: () {
                  setState(() {
                    // ignore: unnecessary_statements
                  });
                },
                child: SizedBox(
                  width: MediaQuery.of(context).size.width,
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: <Widget>[
                      Padding(
                        padding: movement.value,
                        child: Text(
                          "过渡动画切换",
                          style: TextStyle(
                            fontSize: 14.0,
                            fontWeight: FontWeight.bold,
                          ),
                        ),
                      ),
                      Padding(
                        padding: const EdgeInsets.fromLTRB(8.0, 4.0, 0.0, 8.0),
                        child: Text(
                          "多种手机过度动画自由选择",
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
          ],
        ),
        onRefresh: (_handleRefresh),
      );
    }

    if (firstPage == 1) {
      return WillPopScope(
          child: First1(),
          onWillPop: () {
            setState(() {
              firstPage = 0;
              animationController = new AnimationController(
                  duration: const Duration(milliseconds: 1200), vsync: this);
              final Animation curve = CurvedAnimation(
                  parent: animationController, curve: Curves.bounceOut);
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
            });
          });
    }
    if (firstPage == 2) {
      firstPage = 0;
      return WillPopScope(
          child: First2(),
          onWillPop: () {
            setState(() {
              firstPage = 0;
              start();
            });
          });
    }
    if (firstPage == 3) {
      firstPage = 0;
      return WillPopScope(
          child: First3(),
          onWillPop: () {
            setState(() {
              firstPage = 0;
              start();
            });
          });
    }
    if (firstPage == 4) {
      firstPage = 0;
      return WillPopScope(
          child: First4(),
          onWillPop: () {
            setState(() {
              firstPage = 0;
              start();
            });
          });
    }
  }
}
class First1 extends StatefulWidget {
  @override
  _First1State createState() => _First1State();
}

class _First1State extends State<First1> with SingleTickerProviderStateMixin {
  static const platform0 = const MethodChannel("Linux");
  static const platform1 = const MethodChannel("Toast");

  final List<Image> caoNiMa = [
    Image.asset("lib/images/stat_sys_signal_0.png"),
    Image.asset("lib/images/stat_sys_signal_1.png"),
    Image.asset("lib/images/stat_sys_signal_2.png"),
    Image.asset("lib/images/stat_sys_signal_3.png"),
    Image.asset("lib/images/stat_sys_signal_4.png"),
    Image.asset("lib/images/stat_sys_signal_null.png"),
  ];
  final List<Image> guanfang = [
    Image.asset("lib/images/stat_sys_signal_0_darkmode.png"),
    Image.asset("lib/images/stat_sys_signal_1_darkmode.png"),
    Image.asset("lib/images/stat_sys_signal_2_darkmode.png"),
    Image.asset("lib/images/stat_sys_signal_3_darkmode.png"),
    Image.asset("lib/images/stat_sys_signal_4_darkmode.png"),
    Image.asset("lib/images/stat_sys_signal_5_darkmode.png"),
    Image.asset("lib/images/stat_sys_signal_null_darkmode.png"),
  ];
  String single; //信号图标值
  String data = "Data_Default"; //数据图标值
  int single_value;
  int single_default;

  void handleSingleChanged(String value) {
    setState(() {
      single = value.toString();
    });
  }

  void handleDataChanged(String value) {
    setState(() {
      single = value.toString();
    });
  }

  @override
  void initState() {
    single_default ??= 0;
    single_value ??= 0;
    single ??= "Single_Default";
    caonimachange();
    guanfangchange();
    set();
    super.initState();
  }

  Future<Null> set() async {
    SharedPreferences prefs = await SharedPreferences.getInstance();
    prefs.setString('single', '$single');
  }

  Future<Null> guanfangchange() async {
    for (single_default = 0;
        single_default < 6;
        await Future.delayed(Duration(milliseconds: 400), () {
      setState(() {
        single_default++;
      });
    })) {
      if (single_default == 5) {
        await Future.delayed(Duration(milliseconds: 400), () {
          setState(() {
            single_default = 0;
          });
        });
      }
    }
  }

  Future<Null> caonimachange() async {
    for (single_value = 0;
        single_value < 6;
        await Future.delayed(Duration(milliseconds: 400), () {
      setState(() {
        single_value++;
      });
    })) {
      if (single_value == 5) {
        await Future.delayed(Duration(milliseconds: 400), () {
          setState(() {
            single_value = 0;
          });
        });
      }
    }
  }

  @override
  Widget build(BuildContext context) {
    return ListView(
      children: <Widget>[
        Padding(
            padding: const EdgeInsets.fromLTRB(2.0, 2.0, 0.0, 0.0),
            child: Center(
              child: Text(
                "提示：点击将会立即生效",
                style: TextStyle(
                  color: Color(0xff000000),
                  fontSize: 14.0,
                ),
              ),
            )),
        Padding(
          padding: const EdgeInsets.fromLTRB(2.0, 0.0, 0.0, 0.0),
          child: Text(
            "信号图标更改",
            style: TextStyle(
              color: Color(0xff000000),
              fontSize: 14.0,
            ),
          ),
        ),
        Container(
            height: 32,
            child: Scrollbar(
              child: ListView(
                scrollDirection: Axis.horizontal,
                children: <Widget>[
                  Card(
                      child: Stack(
                    children: <Widget>[
                      InkWell(
                        child: guanfang[single_value],
                        onTap: () {
                          handleSingleChanged("Single_Default");
                        },
                      ),
                      Offstage(
                        offstage: true,
                        child: guanfang[0],
                      ),
                      Offstage(
                        offstage: true,
                        child: guanfang[1],
                      ),
                      Offstage(
                        offstage: true,
                        child: guanfang[2],
                      ),
                      Offstage(
                        offstage: true,
                        child: guanfang[3],
                      ),
                      Offstage(
                        offstage: true,
                        child: guanfang[4],
                      ),
                      Offstage(
                        offstage: true,
                        child: guanfang[5],
                      ),
                      Offstage(
                        offstage: true,
                        child: guanfang[6],
                      ),
                    ],
                  )),
                  Radio<String>(
                      value: "Single_Default",
                      groupValue: single,
                      onChanged: handleSingleChanged),
                  Card(
                      child: Stack(
                    children: <Widget>[
                      InkWell(
                        child: caoNiMa[single_value],
                        onTap: () {
                          handleSingleChanged("Single_CaoNiMa");
                        },
                      ),
                      Offstage(
                        offstage: true,
                        child: caoNiMa[0],
                      ),
                      Offstage(
                        offstage: true,
                        child: caoNiMa[1],
                      ),
                      Offstage(
                        offstage: true,
                        child: caoNiMa[2],
                      ),
                      Offstage(
                        offstage: true,
                        child: caoNiMa[3],
                      ),
                      Offstage(
                        offstage: true,
                        child: caoNiMa[4],
                      ),
                      Offstage(
                        offstage: true,
                        child: caoNiMa[5],
                      ),
                    ],
                  )),
                  Radio<String>(
                      value: "Single_CaoNiMa",
                      groupValue: single,
                      onChanged: handleSingleChanged),
                ],
              ),
            )),
        Padding(
          padding: const EdgeInsets.fromLTRB(2.0, 0.0, 0.0, 0.0),
          child: Text(
            "数据图标更改",
            style: TextStyle(
              color: Color(0xff000000),
              fontSize: 14.0,
            ),
          ),
        ),
        Container(
            height: 30,
            child: Scrollbar(
              child: ListView(
                scrollDirection: Axis.horizontal,
                children: <Widget>[
                  Card(
                    child: Text("111"),
                  ),
                  Radio<String>(
                      value: "Single_Default",
                      groupValue: data,
                      onChanged: handleDataChanged),
                  Card(child: Image.asset("lib/images/stat_sys_signal_0.png")),
                  Radio<String>(
                      value: "Single_CaoNiMa",
                      groupValue: data,
                      onChanged: handleDataChanged),
                ],
              ),
            )),
        Align(
          alignment: Alignment.center,
          child: Container(
            width: 200,
            child: Card(
              elevation: 1,
              child: InkWell(
                borderRadius: BorderRadius.circular(4.0),
                onTap: () {
                  Future<Null> set() async {
                    SharedPreferences prefs =
                        await SharedPreferences.getInstance();
                    if (prefs.get('single') == single) {
                      platform1.invokeMethod("你还没有更改任何选择");
                    } else {
                      if (single == 'Single_CaoNiMa') {
                        prefs.setString('single', single);
                        platform0.invokeMethod("mount -o rw,remount /system\n" +
                            "if [ -f \"/system/priv-app/MiuiSystemUI/MiuiSystemUI.bak\" ]; then\n" +
                            "mount -o rw,remount /system\n" +
                            "else\n" +
                            "cp /system/priv-app/MiuiSystemUI/MiuiSystemUI.apk /system/priv-app/MiuiSystemUI/MiuiSystemUI.bak\n" +
                            "fi\n" +
                            "cp /system/priv-app/MiuiSystemUI/MiuiSystemUI.apk /system/priv-app/MiuiSystemUI/MiuiSystemUI.zip\n" +
                            "cd /system/usr/Nightmare/2/Nightmare/4/\$f/\n" +
                            "/system/usr/Nightmare/mengyan -r /system/priv-app/MiuiSystemUI/MiuiSystemUI.zip *\n" +
                            "mv /system/priv-app/MiuiSystemUI/MiuiSystemUI.zip /system/priv-app/MiuiSystemUI/MiuiSystemUI.bak1\n" +
                            "if [ -f \"/system/priv-app/MiuiSystemUI/MiuiSystemUI.bak1\" ]; then\n" +
                            "rm -rf /system/priv-app/MiuiSystemUI/MiuiSystemUI.apk\n" +
                            "mv /system/priv-app/MiuiSystemUI/MiuiSystemUI.bak1 /system/priv-app/MiuiSystemUI/MiuiSystemUI.apk\n" +
                            "else\n" +
                            "mount -o rw,remount /system\n" +
                            "fi\n" +
                            "chmod -R 0644 /system/priv-app/MiuiSystemUI/MiuiSystemUI.apk\n" +
                            "sleep 1\n");
                        platform1.invokeMethod("正在重启状态栏");
                        Future.delayed(Duration(milliseconds: 2000), () {
                          platform0.invokeMethod(
                              "busybox killall com.android.systemui");
                        });
                      }
                    }
                  }

                  set();
                },
                child: SizedBox(
                    height: 44,
                    width: MediaQuery.of(context).size.width,
                    child: Center(
                      child: Text(
                        "应用",
                        style: TextStyle(
                          fontSize: 14.0,
                          fontWeight: FontWeight.bold,
                        ),
                      ),
                    )),
              ),
            ),
          ),
        ),
        Align(
            alignment: Alignment.center,
            child: Column(
              children: <Widget>[
                Text(
                  "提示：已生成的状态栏单刷备份包位于Sdcard/Nightmare",
                  style: TextStyle(
                    color: Color(0xff000000),
                    fontSize: 14.0,
                  ),
                ),
                Text(
                  "请勿手动删除MiuiSystem下后缀名为bak的文件",
                  style: TextStyle(
                    color: Color(0xff000000),
                    fontSize: 14.0,
                  ),
                ),
                Text(
                  "xml脚本失效导致状态栏无法重启直接进入REC刷入单刷包",
                  style: TextStyle(
                    color: Color(0xff000000),
                    fontSize: 14.0,
                  ),
                ),
              ],
            )),
      ],
    );
  }
}
class First2 extends StatelessWidget {
  static const platform = const MethodChannel("First2");
  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      body: ListView(
        children: <Widget>[
          Padding(
            padding: const EdgeInsets.fromLTRB(2.0, 2.0, 0.0, 0.0),
            child: Text(
              "提示：点击后选择重启后生效",
              style: TextStyle(
                color: Color(0xff000000),
                fontSize: 14.0,
              ),
            ),
          ),
          Padding(
            padding: const EdgeInsets.fromLTRB(2.0, 0.0, 0.0, 0.0),
            child: Text(
              "仿IOS布局 + 图标",
              style: TextStyle(
                color: Color(0xff000000),
                fontSize: 14.0,
              ),
            ),
          ),
          Padding(
              padding: const EdgeInsets.fromLTRB(2.0, 0.0, 0.0, 0.0),
              child: Image.asset("lib/images/systemui_iosui.png")),

          Padding(
            padding: const EdgeInsets.fromLTRB(2.0, 0.0, 0.0, 0.0),
            child: Text(
              "时间居中 + 信号居左",
              style: TextStyle(
                color: Color(0xff000000),
                fontSize: 14.0,
              ),
            ),
          ),
          Padding(
              padding: const EdgeInsets.fromLTRB(2.0, 0.0, 0.0, 0.0),
              child: Image.asset("lib/images/systemui_ios.png")),
          Padding(
            padding: const EdgeInsets.fromLTRB(2.0, 0.0, 0.0, 0.0),
            child: Text(
              "官方默认布局",
              style: TextStyle(
                color: Color(0xff000000),
                fontSize: 14.0,
              ),
            ),
          ),

          Padding(
              padding: const EdgeInsets.fromLTRB(2.0, 0.0, 0.0, 0.0),
              child: Image.asset("lib/images/systemui_default.png")),
          Padding(
            padding: const EdgeInsets.fromLTRB(2.0, 0.0, 0.0, 0.0),
            child: Text(
              "草泥马信号 + 时间居中 + 信号居左",
              style: TextStyle(
                color: Color(0xff000000),
                fontSize: 14.0,
              ),
            ),
          ),
          Padding(
              padding: const EdgeInsets.fromLTRB(2.0, 0.0, 0.0, 0.0),
              child: Image.asset("lib/images/systemui_nightmare.png")),
          InkWell(
            onTap: ()=> platform.invokeMethod("CaoNiMa"),
            child: Padding(
                padding: const EdgeInsets.fromLTRB(2.0, 0.0, 0.0, 0.0),
                child: Image.asset("lib/images/home.png")),
          ),
        ],
      ),
    );
  }
}
class First3 extends StatelessWidget {
  static const platform = const MethodChannel("First3");
  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      body: ListView(
        children: <Widget>[
          Padding(
            padding: const EdgeInsets.fromLTRB(2.0, 2.0, 0.0, 0.0),
            child: Text(
              "提示：点击返回桌面后生效",
              style: TextStyle(
                color: Color(0xff000000),
                fontSize: 14.0,
              ),
            ),
          ),
          Padding(
            padding: const EdgeInsets.fromLTRB(2.0, 0.0, 0.0, 0.0),
            child: Text(
              "图标 4X5",
              style: TextStyle(
                color: Color(0xff000000),
                fontSize: 14.0,
              ),
            ),
          ),
          InkWell(
            onTap: ()=> {},
            child: Padding(
                padding: const EdgeInsets.fromLTRB(2.0, 0.0, 0.0, 0.0),
                child: Image.asset("lib/images/home.png")),
          ),

          Padding(
            padding: const EdgeInsets.fromLTRB(2.0, 0.0, 0.0, 0.0),
            child: Text(
              "图标 4X6",
              style: TextStyle(
                color: Color(0xff000000),
                fontSize: 14.0,
              ),
            ),
          ),
          InkWell(
            onTap: ()=> {},
            child: Padding(
                padding: const EdgeInsets.fromLTRB(2.0, 0.0, 0.0, 0.0),
                child: Image.asset("lib/images/home.png")),
          ),
          Padding(
            padding: const EdgeInsets.fromLTRB(2.0, 0.0, 0.0, 0.0),
            child: Text(
              "图标 5X5",
              style: TextStyle(
                color: Color(0xff000000),
                fontSize: 14.0,
              ),
            ),
          ),
          InkWell(
            onTap: ()=> {},
            child: Padding(
                padding: const EdgeInsets.fromLTRB(2.0, 0.0, 0.0, 0.0),
                child: Image.asset("lib/images/home.png")),
          ),
          Padding(
            padding: const EdgeInsets.fromLTRB(2.0, 0.0, 0.0, 0.0),
            child: Text(
              "图标 5X6",
              style: TextStyle(
                color: Color(0xff000000),
                fontSize: 14.0,
              ),
            ),
          ),
          InkWell(
            onTap: ()=> {},
            child: Padding(
                padding: const EdgeInsets.fromLTRB(2.0, 0.0, 0.0, 0.0),
                child: Image.asset("lib/images/home.png")),
          ),
        ],
      ),
    );
  }
}
class First4 extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      body: ListView(
        children: <Widget>[

        ],
      ),
    );
  }
}
