import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

int fourthPage;

class Fourth extends StatefulWidget {
  @override
  _FourthState createState() => _FourthState();
}

class _FourthState extends State<Fourth> with SingleTickerProviderStateMixin {
  AnimationController animationController;
  Animation<EdgeInsets> movement;
  static const platform0 = const MethodChannel("Linux");
  static const platform = const MethodChannel("Fourth");
  static const platform1 = const MethodChannel("Toast");

  @override
  void initState() {
    fourthPage ??= 0;
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
    super.initState();
  }

  @override
  void dispose() {
    animationController.dispose();
    super.dispose();
  }

  Future<Null> _dialog(String title, String invokeMethod) async {
    return showDialog<Null>(
      context: context,
      barrierDismissible: true, // user must tap button!
      builder: (BuildContext context) {
        return AlertDialog(
          content: Text(
            title,
            style: TextStyle(
              fontSize: 18.0,
              fontWeight: FontWeight.bold,
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
                '确认',
                style: TextStyle(
                  fontSize: 14.0,
                  fontWeight: FontWeight.bold,
                ),
              ),
              onPressed: () {
                platform0.invokeMethod(invokeMethod);
                Navigator.of(context).pop();
              },
            ),
          ],
        );
      },
    );
  }

  _fourthPage() {
    if (fourthPage == 0) {
      return ListView(
        children: <Widget>[
          Padding(
            padding: movement.value - EdgeInsets.fromLTRB(8.0, 8.0, 0.0, 0.0),
          ),
          Padding(
            padding: movement.value - EdgeInsets.fromLTRB(8.0, 8.0, 0.0, 0.0),
            child: Text(
              "系统",
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
                        "黑域",
                        style: TextStyle(
                          fontSize: 14.0,
                          fontWeight: FontWeight.bold,
                        ),
                      ),
                    ),
                    Padding(
                      padding: const EdgeInsets.fromLTRB(8.0, 4.0, 0.0, 8.0),
                      child: Text(
                        "打开黑域(自动执行脚本)",
                        style: TextStyle(
                          color: Color(0xff696666),
                          fontSize: 12.0,
                        ),
                      ),
                    ),
                  ],
                ),
              ),
              onTap: () => platform.invokeMethod("HeiYu"),
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
                        "程序冻结",
                        style: TextStyle(
                          fontSize: 14.0,
                          fontWeight: FontWeight.bold,
                        ),
                      ),
                    ),
                    Padding(
                      padding: const EdgeInsets.fromLTRB(8.0, 4.0, 0.0, 8.0),
                      child: Text(
                        "冻结用户应用或系统应用",
                        style: TextStyle(
                          color: Color(0xff696666),
                          fontSize: 12.0,
                        ),
                      ),
                    ),
                  ],
                ),
              ),
              onTap: () => platform.invokeMethod("DongJie"),
            ),
          ),
          Padding(
            padding: movement.value - EdgeInsets.fromLTRB(8.0, 8.0, 0.0, 0.0),
            child: Text(
              "声音",
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
                        "蝰蛇音效",
                        style: TextStyle(
                          fontSize: 14.0,
                          fontWeight: FontWeight.bold,
                        ),
                      ),
                    ),
                    Padding(
                      padding: const EdgeInsets.fromLTRB(8.0, 4.0, 0.0, 8.0),
                      child: Text(
                        "进入蝰蛇音效设置",
                        style: TextStyle(
                          color: Color(0xff696666),
                          fontSize: 12.0,
                        ),
                      ),
                    ),
                  ],
                ),
              ),
              onTap: () => platform.invokeMethod("KuiShe"),
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
                        "杜比音效",
                        style: TextStyle(
                          fontSize: 14.0,
                          fontWeight: FontWeight.bold,
                        ),
                      ),
                    ),
                    Padding(
                      padding: const EdgeInsets.fromLTRB(8.0, 4.0, 0.0, 8.0),
                      child: Text(
                        "进入杜比音效设置",
                        style: TextStyle(
                          color: Color(0xff696666),
                          fontSize: 12.0,
                        ),
                      ),
                    ),
                  ],
                ),
              ),
              onTap: () => platform.invokeMethod("DuBi"),
            ),
          ),
          Padding(
            padding: movement.value - EdgeInsets.fromLTRB(8.0, 8.0, 0.0, 0.0),
            child: Text(
              "其他",
              style: TextStyle(
                color: Color(0x90303030),
                fontSize: 14.0,
              ),
            ),
          ),
          Card(
            elevation: 1,
            child: InkWell(
              onTap: () {
                setState(() {
                  fourthPage = 1;
                });
              },
              borderRadius: BorderRadius.circular(4.0),
              child: SizedBox(
                width: MediaQuery.of(context).size.width,
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: <Widget>[
                    Padding(
                      padding: movement.value,
                      child: Text(
                        "WIFI密码查看",
                        style: TextStyle(
                          fontSize: 14.0,
                          fontWeight: FontWeight.bold,
                        ),
                      ),
                    ),
                    Padding(
                      padding: const EdgeInsets.fromLTRB(8.0, 4.0, 0.0, 8.0),
                      child: Text(
                        "查看已连接的WIFI密码",
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
                        "打开网络ADB调试",
                        style: TextStyle(
                          fontSize: 14.0,
                          fontWeight: FontWeight.bold,
                        ),
                      ),
                    ),
                    Padding(
                      padding: const EdgeInsets.fromLTRB(8.0, 4.0, 0.0, 8.0),
                      child: Text(
                        "与电脑处于同一WIFI，使用命令行输入 adb connext IP:5555",
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
                _dialog(
                    "确认开启吗",
                    "setprop service.adb.tcp.port 5555" +
                        "stop adbd" +
                        "sleep 1" +
                        "start adbd");
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
                        "删除电池使用记录",
                        style: TextStyle(
                          fontSize: 14.0,
                          fontWeight: FontWeight.bold,
                        ),
                      ),
                    ),
                    Padding(
                      padding: const EdgeInsets.fromLTRB(8.0, 4.0, 0.0, 8.0),
                      child: Text(
                        "清空系统的电池使用记录，需要重启系统",
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
                _dialog(
                    "确认删除吗，点击确定马上重启",
                    "rm -f /data/system/batterystats-checkin.bin" +
                        "rm -f /data/system/batterystats-daily.xml" +
                        "rm -f /data/system/batterystats.bin" +
                        "sleep 1" +
                        "reboot");
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
                        "RAM内存清理",
                        style: TextStyle(
                          fontSize: 14.0,
                          fontWeight: FontWeight.bold,
                        ),
                      ),
                    ),
                    Padding(
                      padding: const EdgeInsets.fromLTRB(8.0, 4.0, 0.0, 8.0),
                      child: Text(
                        "清理RAM",
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
                platform1.invokeMethod("echo 3 > /proc/sys/vm/drop_caches");
                platform0.invokeMethod("echo 3 > /proc/sys/vm/drop_caches");
              },
            ),
          ),
        ],
      );
    }
    if (fourthPage == 1) {
        return WillPopScope(
            child: WIFI(),
            onWillPop: () {
              setState(() {
                fourthPage = 0;
              });
            });
      }
  }

  @override
  Widget build(BuildContext context) {
    return _fourthPage();
  }
}

class WIFI extends StatefulWidget {
  @override
  _WIFIState createState() => _WIFIState();
}

class _WIFIState extends State<WIFI> {
  @override
  Widget build(BuildContext context) {
    return ListView(
      children: <Widget>[],
    );
  }
}
