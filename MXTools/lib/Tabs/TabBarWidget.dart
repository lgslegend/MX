import 'package:flutter/material.dart';
import 'package:package_info/package_info.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'package:mx/Dialog/Dialog1.dart';
import 'package:mx/Dialog/Dialog2.dart';
import 'package:mx/Dialog/Dialog3.dart';

int tabBar;
double c;
TabController tabController;

double _indexChangeProgress(TabController controller) {
  final double controllerValue = controller.animation.value;
  final double previousIndex = controller.previousIndex.toDouble();
  final double currentIndex = controller.index.toDouble();

  // The controller's offset is changing because the user is dragging the
  // TabBarView's PageView to the left or right.
  if (!controller.indexIsChanging)
    return (currentIndex - controllerValue).abs().clamp(0.0, 1.0);

  // The TabController animation's value is changing from previousIndex to currentIndex.
  return (controllerValue - currentIndex).abs() /
      (currentIndex - previousIndex).abs();
}

class TabBarWidget extends StatefulWidget {
  final List<Widget> tabItems;
  final List<Widget> tabViews;
  final Color backgroundColor;
  final Color indicatorColor;
  final Widget title;
  final Widget drawer;
  final Widget floatingActionButton;

  TabBarWidget({
    Key key,
    this.tabItems,
    this.tabViews,
    this.backgroundColor,
    this.indicatorColor,
    this.title,
    this.drawer,
    this.floatingActionButton,
  }) : super(key: key);

  @override
  _TabBarState createState() => new _TabBarState(tabItems, tabViews,
      backgroundColor, indicatorColor, title, drawer, floatingActionButton);
}

Animation<Color> tabcolor;
Color cc;

class _TabBarState extends State<TabBarWidget> with TickerProviderStateMixin {
  final List<Widget> _tabItems;
  final List<Widget> _tabViews;
  final Color _backgroundColor;
  final Color _indicatorColor;
  final Widget _title;
  final Widget _drawer;
  final Widget _floatingActionButton;

  AnimationController dialoganimation;
  AnimationController animationController;
  Animation<EdgeInsets> movement;
  Animation<EdgeInsets> dialog;
  AnimationController tabcolorController;

  ColorTween selectedColorTween;
  int a;

  void aa() {
    tabController.animateTo(0);
  }

  _TabBarState(
      this._tabItems,
      this._tabViews,
      this._backgroundColor,
      this._indicatorColor,
      this._title,
      this._drawer,
      this._floatingActionButton)
      : super();

  final List<Color> _colors = [
    Color(0xff303030),
    Color(0xff213349),
    Color(0xffbd4a4a),
    Color(0xff25816b),
    Color(0xff4a3434),
    Color(0xff4c5fb7),
  ];

  @override
  void initState() {
    super.initState();
    tabBar ??= 0;
    a ??= _tabItems.length - 1;
    c ??= 48;
    cc ??= _colors[0];
    tabController =
        TabController(length: _tabItems.length, vsync: this, initialIndex: a);
    tabController.animation.addListener(() {
      setState(() {
        if (tabController.indexIsChanging) {
          final double t = 1.0 - _indexChangeProgress(tabController);
          final ColorTween mysColor = ColorTween(
            begin: _colors[tabController.previousIndex],
            end: _colors[tabController.index],
          );
          cc = mysColor.lerp(t);
        } else {
          if (tabController.offset > 0) {
            final ColorTween mysColor = ColorTween(
              begin: _colors[tabController.index],
              end: _colors[tabController.index + 1],
            );
            cc = mysColor.lerp(tabController.offset);
          }
          if (tabController.offset < 0) {
            final ColorTween mysColor = ColorTween(
              begin: _colors[tabController.index],
              end: _colors[tabController.index - 1],
            );
            cc = mysColor.lerp(-tabController.offset);
          }
        }
      });
    });

    animationController = new AnimationController(
        duration: const Duration(milliseconds: 1600), vsync: this);
    final Animation curve1 =
        CurvedAnimation(parent: animationController, curve: Curves.bounceOut);
    movement = EdgeInsetsTween(
      begin: const EdgeInsets.fromLTRB(300.0, 0, 0.0, 0.0),
      end: const EdgeInsets.fromLTRB(0.0, 0, 0.0, 0.0),
    ).animate(curve1);
    movement.addListener(() {
      setState(() {
        // the state that has changed here is the animation object’s value
      });
    });
    start();
    dleRefresh();
    _neverSatisfied();
  }

  Future<Null> fresh() async {
    return showDialog<Null>(
      context: context,
      barrierDismissible: true, // (false)user must tap button!
      builder: (BuildContext context) {
        return Dialog2();
      },
    );
  }

  Future<Null> fresh1() async {
    return showDialog<Null>(
      context: context,
      barrierDismissible: true, // (false)user must tap button!
      builder: (BuildContext context) {
        return Dialog3();
      },
    );
  }

  Future<Null> _neverSatisfied() async {
    PackageInfo packageInfo = await PackageInfo.fromPlatform();
    // String appName = packageInfo.appName;
    // String packageName = packageInfo.packageName;
    // String version = packageInfo.version;
    String buildNumber = packageInfo.buildNumber;
    SharedPreferences prefs = await SharedPreferences.getInstance();
    if (prefs.getInt("VERSION_KEY") == null) {
      prefs.setInt('VERSION_KEY', 0);
    }
    int lastVersion = prefs.getInt("VERSION_KEY");
    int currentVersion = int.parse(buildNumber);
    if (currentVersion > lastVersion) {
      return showDialog<Null>(
        context: context,
        barrierDismissible: true, // (false)user must tap button!
        builder: (BuildContext context) {
          return Dialog1();
        },
      );
    } else {}
  }

  Future<Null> dleRefresh() async {
    await Future.delayed(Duration(milliseconds: 400), () {
      setState(() {});
      print("tab移动了");
      tabController.animateTo(0);
    });
  }

  void start() {
    print("动画启动了");
    animationController.forward();
  }

  @override
  void dispose() {
    tabController.dispose();
    super.dispose();
  }

  _titleAnimation() {
    return Row(
      crossAxisAlignment: CrossAxisAlignment.center,
      children: <Widget>[
        Padding(
          padding: movement.value,
          child: Text("MX"),
        ),
        PreferredSize(
            child: Align(
              alignment: Alignment.centerRight,
            ),
            preferredSize: Size.fromHeight(0)),
      ],
    );
  }

  _tabBar() {
    //修复releaseTabBar的Bug
    //这里可以加动画
    if (tabBar == 0) {
      return PreferredSize(
          child: Padding(
            padding: EdgeInsets.fromLTRB(0, 0, 0, 0),
            child: TabBar(
              isScrollable: true,
              controller: tabController,
              tabs: _tabItems,
              indicatorColor: _indicatorColor,
            ),
          ),
          preferredSize: Size.fromHeight(0)); //这段保留状态栏

    }
    if (tabBar == 1) {
      return TabBar(
        isScrollable: true,
        controller: tabController,
        tabs: _tabItems,
        indicatorColor: _indicatorColor,
      );
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      drawer: _drawer,
      endDrawer: _drawer,
      floatingActionButton: _floatingActionButton,
      appBar: PreferredSize(
          child: AppBar(
            elevation: 0.0,
            primary: true,
            backgroundColor: cc,
          ),
          preferredSize: Size.fromHeight(0)), //这段保留状态栏
      body: NestedScrollView(
        headerSliverBuilder: (BuildContext context, bool innerBoxIsScrolled) {
          return <Widget>[
            SliverPersistentHeader(
              pinned: false,
              delegate: _AppBarBuilder(
                AppBar(
                  leading: Builder(
                    builder: (BuildContext context) {
                      return Align(
                        alignment: Alignment.center,
                        child: Container(
                          decoration: BoxDecoration(
                              borderRadius: BorderRadius.circular(25)),
                          height: 36,
                          width: 36,
                          child: InkWell(
                            borderRadius: BorderRadius.circular(25),
                            child: const Icon(Icons.menu),
                            onTap: () {
                              Scaffold.of(context).openDrawer();
                            },
                          ),
                        ),
                      );
                    },
                  ),
                  backgroundColor: cc, //是否固定
                  elevation: 0.0, //这个是阴影
                  primary: false,
                  title: _titleAnimation(),
                  actions: <Widget>[
                    Padding(
                      padding: EdgeInsets.fromLTRB(0, 0, 12, 0),
                      child: Container(
                        decoration: BoxDecoration(
                            borderRadius: BorderRadius.circular(25)),
                        height: 36,
                        width: 36,
                        child: InkWell(
                          borderRadius: BorderRadius.circular(25),
                          child: const Icon(Icons.power_settings_new),
                          onTap: () {
                            fresh();
                          },
                        ),
                      ),
                    ),
                    Padding(
                      padding: EdgeInsets.fromLTRB(0, 0, 12, 0),
                      child: Container(
                        decoration: BoxDecoration(
                            borderRadius: BorderRadius.circular(25)),
                        height: 36,
                        width: 36,
                        child: InkWell(
                          borderRadius: BorderRadius.circular(25),
                          child: const Icon(Icons.settings),
                          onTap: () {
                            fresh1();
                          },
                        ),
                      ),
                    ),
                  ],
                ),
              ),
            ),
            SliverOverlapAbsorber(
              handle: NestedScrollView.sliverOverlapAbsorberHandleFor(context),
              child: SliverPersistentHeader(
                pinned: true,
                delegate: _TabBarBuilder(
                  AppBar(
                    backgroundColor: cc,
                    elevation: 4.0,
                    primary: false,
                    bottom: _tabBar(),
                  ),
                ),
              ),
            ),
          ];
        },
        body: Container(
          padding: EdgeInsets.fromLTRB(0, 48, 0, 0),
          child: TabBarView(controller: tabController, children: _tabViews),
        ),
      ),
    );
  }
}

class _TabBarBuilder extends SliverPersistentHeaderDelegate {
  _TabBarBuilder(this._tbBar);

  final AppBar _tbBar;

  @override
  double get minExtent => c;

  @override
  double get maxExtent => c;

  @override
  Widget build(
      BuildContext context, double shrinkOffset, bool overlapsContent) {
    return new Container(
      color: cc,
      child: _tbBar,
    );
  }

  @override
  bool shouldRebuild(_TabBarBuilder oldDelegate) {
    return true; //是否及时更改
  }
}

class _AppBarBuilder extends SliverPersistentHeaderDelegate {
  _AppBarBuilder(this._tbBar);

  final AppBar _tbBar;

  @override
  double get minExtent => 36;

  @override
  double get maxExtent => 36;

  @override
  Widget build(
      BuildContext context, double shrinkOffset, bool overlapsContent) {
    return new Container(
      color: cc,
      child: _tbBar,
    );
  }

  @override
  bool shouldRebuild(_AppBarBuilder oldDelegate) {
    return true; //是否及时更改
  }
}

class Dialog1 extends StatefulWidget {
  @override
  State<StatefulWidget> createState() => Dialog1State();
}

class Dialog1State extends State<Dialog1> with SingleTickerProviderStateMixin {
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
              Future<Null> set() async {
                SharedPreferences prefs = await SharedPreferences.getInstance();
                PackageInfo packageInfo = await PackageInfo.fromPlatform();
                String buildNumber = packageInfo.buildNumber;
                int currentVersion = int.parse(buildNumber);
                prefs.setInt('VERSION_KEY', currentVersion);
              }

              set();
              Navigator.of(context).pop();
            },
          ),
        ],
      ),
    );
  }
}
