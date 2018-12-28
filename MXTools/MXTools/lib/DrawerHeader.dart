import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

class DrawerBuilder extends StatefulWidget {
  @override
  _DrawerBuilderState createState() => _DrawerBuilderState();
}

class _DrawerBuilderState extends State<DrawerBuilder> {
  static const platform = const MethodChannel("DrawerHeader");
  static Widget _drawerHeader() {
    return new DrawerHeader(
        child: Image.asset("lib/images/tangxueyi1.png"),
        decoration: BoxDecoration(color: Color(0xFF303030)));
  }
  @override
  Widget build(BuildContext context) {
    return Drawer(
      child: ListView(padding: const EdgeInsets.only(), children: <Widget>[
        DrawerHeader(
            child: Align(
                alignment: Alignment.centerLeft,
                child: SizedBox(
                  height: 80,
                  child: Image.asset("lib/images/tangxueyi1.png"),
                )),
            decoration: BoxDecoration(color: Color(0xFF303030))),
        InkWell(
          child: Container(
            height: 48,
            child: Row(
              crossAxisAlignment: CrossAxisAlignment.center,
              children: <Widget>[
                Container(
                  height: 24,
                  padding: EdgeInsets.fromLTRB(10, 0, 0, 0),
                  child: Icon(Icons.email),
                ),
                Padding(
                  padding: EdgeInsets.fromLTRB(30, 0, 0, 0),
                  child: Text(
                    '反馈建议',
                    style: TextStyle(
                      fontSize: 16.0,
                    ),
                  ),
                ),
              ],
            ),
          ),
          onTap: () => platform.invokeMethod("BugReport"),
        ),
        InkWell(
          child: Container(
            height: 48,
            child: Row(
              crossAxisAlignment: CrossAxisAlignment.center,
              children: <Widget>[
                Container(
                  height: 24,
                  padding: EdgeInsets.fromLTRB(10, 0, 0, 0),
                  child: Icon(Icons.cached),
                ),
                Padding(
                  padding: EdgeInsets.fromLTRB(30, 0, 0, 0),
                  child: Text('检查更新',
                      style: TextStyle(
                        fontSize: 16.0,
                      )),
                ),
              ],
            ),
          ),
          onTap: () => platform.invokeMethod("Check"),
        ),
        InkWell(
          child: Container(
            height: 48,
            child: Row(
              crossAxisAlignment: CrossAxisAlignment.center,
              children: <Widget>[
                Container(
                  height: 24,
                  padding: EdgeInsets.fromLTRB(10, 0, 0, 0),
                  child: Icon(Icons.info),
                ),
                Padding(
                  padding: EdgeInsets.fromLTRB(30, 0, 0, 0),
                  child: Text('软件关于',
                      style: TextStyle(
                        fontSize: 16.0,
                      )),
                ),
              ],
            ),
          ),
          onTap: () => platform.invokeMethod("About"),
        ),
        InkWell(
          child: Container(
            height: 48,
            child: Row(
              crossAxisAlignment: CrossAxisAlignment.center,
              children: <Widget>[
                Container(
                  height: 24,
                  padding: EdgeInsets.fromLTRB(10, 0, 0, 0),
                  child: Icon(Icons.exit_to_app),
                ),
                Padding(
                  padding: EdgeInsets.fromLTRB(30, 0, 0, 0),
                  child: Text('退出软件',
                      style: TextStyle(
                        fontSize: 16.0,
                      )),
                ),
              ],
            ),
          ),
          onTap: () => platform.invokeMethod("Exit"),
        ),
        Divider(),
        Row(
          children: <Widget>[
            Container(
              height: 50,
              child: Image.asset("lib/images/raw/reboot_big.png"),
            ),
            Container(
              height: 50,
              child: 
            Image.asset("lib/images/raw/recovery_big.png"),
            ),
            Container(
              height: 50,
              child: Image.asset("lib/images/raw/fastboot_big.png"),
            ),
            
          ],
        )
      ]),
    );
  }
}

class HomeBuilder {
  static const platform = const MethodChannel("DrawerHeader");
  static Widget homeDrawer() {
    return Drawer();
  }

}
