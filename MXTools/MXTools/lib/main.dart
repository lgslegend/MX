import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'Tabs/First.dart';
import 'Tabs/Second.dart';
import 'Tabs/Third.dart';
import 'Tabs/Fourth.dart';
import 'Tabs/Fifth.dart';
import 'Tabs/Sixth.dart';
import 'Tabs/TabBarWidget.dart';
import 'DrawerHeader.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'package:package_info/package_info.dart';

void main() {
  runApp(Nightmare());
}

class Nightmare extends StatefulWidget {
  @override
  _NightmareState createState() => _NightmareState();
}

class _NightmareState extends State<Nightmare>
    with SingleTickerProviderStateMixin {
  static const platform = const MethodChannel("DrawerHeader");

  @override
  void initState() {
    _neverSatisfied();
    super.initState();
    _neverSatisfied();
  }
  Future<Null> _neverSatisfied() async {
    return showDialog<Null>(
      context: context,
      barrierDismissible: true, // user must tap button!
      builder: (BuildContext context) {
        return AlertDialog(
          title: Text('Rewind and remember'),
          content: SingleChildScrollView(
            child: ListBody(
              children: <Widget>[
                Text('You will never be satisfied.'),
                Text('You\’re like me. I’m never satisfied.'),
              ],
            ),
          ),
          actions: <Widget>[
            FlatButton(
              child: Text('Regret'),
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
  void dispose() {
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return new MaterialApp(
        theme: ThemeData(
          accentColor: Color(0xff303030),
          primaryColor: Color(0xff303030),
        ),
        home: new RefreshIndicator(
          child: TabBarWidget(
            tabItems: _renderTab(),
            tabViews: _renderPage(),
            drawer: DrawerBuilder(),
            //backgroundColor: tabcolor.value,
            indicatorColor: Colors.white,
            title: new Text("MX"),
          ),
          onRefresh: () {},
        ));
  }

  final List<Widget> list1 = [
    Tab(
      text: "MIUI布局修改",
    ),
    Tab(
      child: Text("XPOSED框架"),
    ),
    Tab(
      child: Text("系统修改"),
    ),
    Tab(
      child: Text("实用工具"),
    ),
    Tab(
      child: Text("系统快捷"),
    ),
    Tab(
      child: Text("辅助功能"),
    ),
  ];
  final List<Widget> list2 = [
    Tab(
      text: "MIUI布局修改",
    ),
    Tab(
      child: Text("系统修改"),
    ),
    Tab(
      child: Text("实用工具"),
    ),
    Tab(
      child: Text("系统快捷"),
    ),
    Tab(
      child: Text("辅助功能"),
    ),
  ];

  _renderTab() {
    return list2;
  }

  _renderPage() {
    return <Widget>[
      new First(),
      new Third(),
      Fourth(),
      Fifth(),
      new Sixth(),
    ];
  }
}
