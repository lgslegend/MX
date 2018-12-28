import 'package:flutter/material.dart';
import "package:mx/Tabs/TabBarWidget.dart";

class Dialog1 extends StatefulWidget {
  @override
  State<StatefulWidget> createState() => Dialog1State();
}
 
class Dialog1State extends State<Dialog1> with SingleTickerProviderStateMixin{
  AnimationController dialoganimation;
  Animation<EdgeInsets> dialog;
  @override
  void initState() {
    super.initState();
    dialoganimation = new AnimationController(
        duration: const Duration(milliseconds: 1600), vsync: this);
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
            child: AlertDialog(
              title: Text(
                '更新日志',
                style: TextStyle(
                  fontSize: 20.0,
                  fontWeight: FontWeight.bold,
                ),
              ),
              content: SingleChildScrollView(
                child: ListBody(
                  children: <Widget>[
                    Text(
                      "V1.04 (2018年12月17日）\n"
                          "代码全部重写，采用谷歌Flutter跨平台框架\n"
                          "软件原生跟Flutter混合开发\n"
                          "\n"
                          "V1.03 (2018年10月15日）\n" +
                          "兼容安卓8.0，重写大量代码\n" +
                          "\n" +
                          "V1.02 (2018年07月01日)\n" +
                          "软件界面换新，代码全部重写，采用NavigationView+ToolBar+TabLayout+ViewPager+Fragment布局\n" +
                          "\n" +
                          "版本 v1.01 (2018年02月13日)\n" +
                          "修复一些可执行的脚本\n" +
                          "\n" +
                          "V1.0 (2018年02月04日)\n" +
                          "程序的开始\n" +
                          "PreferenceFragment继承AppCompatActivity布局，局限性大\n" +
                          "简单的布局，简单的代码，实用的功能\n" +
                          "采用大量线程处理\n" +
                          "软件不开源,禁止盗用反编译后得到的源码",
                      style: TextStyle(
                        fontSize: 16.0,
                        fontWeight: FontWeight.bold,
                      ),
                    ),
                  ],
                ),
                physics: const AlwaysScrollableScrollPhysics(),
              ),
              actions: <Widget>[
                FlatButton(
                  child: Text(
                    '不再显示',
                    style: TextStyle(
                      fontSize: 14.0,
                      fontWeight: FontWeight.bold,
                    ),
                  ),
                  onPressed: () {
                    Set();
                    Navigator.of(context).pop();
                  },
                ),
              ],
            ),
          );
  }
}