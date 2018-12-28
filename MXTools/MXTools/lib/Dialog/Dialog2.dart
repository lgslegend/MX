import 'package:flutter/material.dart';
import 'AlertDialogBuilder.dart';
import 'package:flutter/services.dart';

class Dialog2 extends StatefulWidget {
  @override
  State<StatefulWidget> createState() => Dialog2State();
}

class Dialog2State extends State<Dialog2> with SingleTickerProviderStateMixin {
  static const platform0 = const MethodChannel("Linux");
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
        //print(dialoganimation.value);
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
          height: 400,
          child: Column(
            children: <Widget>[
              Padding(
                padding: EdgeInsets.fromLTRB(8.0, 8.0, 0.0, 0.0),
                child: Text(
                  "选择你的操作",
                  style: TextStyle(
                    color: Color(0x90303030),
                    fontSize: 20.0,
                  ),
                ),
              ),
              Card(
                elevation: 1,
                child: InkWell(
                  borderRadius: BorderRadius.circular(4.0),
                  onTap: () {
                    platform0.invokeMethod("reboot -p");
                  },
                  child: SizedBox(
                    height: 52,
                    width: MediaQuery.of(context).size.width,
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: <Widget>[
                        Padding(
                          padding:
                              const EdgeInsets.fromLTRB(8.0, 16.0, 0.0, 0.0),
                          child: Text(
                            "快速关机",
                            style: TextStyle(
                              fontSize: 14.0,
                              fontWeight: FontWeight.bold,
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
                  onTap: () {
                    platform0.invokeMethod("reboot");
                  },
                  child: SizedBox(
                    height: 52,
                    width: MediaQuery.of(context).size.width,
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: <Widget>[
                        Padding(
                          padding:
                              const EdgeInsets.fromLTRB(8.0, 16.0, 0.0, 0.0),
                          child: Text(
                            "快速重启",
                            style: TextStyle(
                              fontSize: 14.0,
                              fontWeight: FontWeight.bold,
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
                  onTap: () {
                    platform0.invokeMethod("busybox killall system_server");
                  },
                  child: SizedBox(
                    height: 52,
                    width: MediaQuery.of(context).size.width,
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: <Widget>[
                        Padding(
                          padding:
                              const EdgeInsets.fromLTRB(8.0, 16.0, 0.0, 0.0),
                          child: Text(
                            "热重启",
                            style: TextStyle(
                              fontSize: 14.0,
                              fontWeight: FontWeight.bold,
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
                  onTap: () {
                    platform0.invokeMethod("reboot bootloader");
                  },
                  child: SizedBox(
                    height: 52,
                    width: MediaQuery.of(context).size.width,
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: <Widget>[
                        Padding(
                          padding:
                              const EdgeInsets.fromLTRB(8.0, 16.0, 0.0, 0.0),
                          child: Text(
                            "进入Fastboot",
                            style: TextStyle(
                              fontSize: 14.0,
                              fontWeight: FontWeight.bold,
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
                  onTap: () {
                    platform0.invokeMethod("reboot recovery");
                  },
                  child: SizedBox(
                    height: 52,
                    width: MediaQuery.of(context).size.width,
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: <Widget>[
                        Padding(
                          padding:
                              const EdgeInsets.fromLTRB(8.0, 16.0, 0.0, 0.0),
                          child: Text(
                            "进入Recovery",
                            style: TextStyle(
                              fontSize: 14.0,
                              fontWeight: FontWeight.bold,
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
                  onTap: () {
                    platform0.invokeMethod("reboot edl");
                  },
                  child: SizedBox(
                    height: 52,
                    width: MediaQuery.of(context).size.width,
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: <Widget>[
                        Padding(
                          padding:
                              const EdgeInsets.fromLTRB(8.0, 16.0, 0.0, 0.0),
                          child: Text(
                            "进入9008模式",
                            style: TextStyle(
                              fontSize: 14.0,
                              fontWeight: FontWeight.bold,
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
        )
      ),
    );
  }
}
