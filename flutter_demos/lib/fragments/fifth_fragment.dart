import 'package:flutter/material.dart';
import 'package:flutter_parallax/flutter_parallax.dart';


class FifthFragment extends StatelessWidget {
  static const String routeName = "/fifth_fragment";

  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return new Center(
      child: MyHomePage(title: 'Parallax demo'),
    );
  }

}
class MyHomePage extends StatefulWidget {
  MyHomePage({Key key, this.title}) : super(key: key);

  final String title;

  @override
  _MyHomePageState createState() => new _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  ScrollController _scrollController;

  @override
  void initState() {
    super.initState();
    _scrollController = new ScrollController();
  }

  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      body: new Stack(
        children: <Widget>[
          new Parallax.outside(
            controller: _scrollController,
            child: new Column(
              children: <Widget>[
                new Container(
                  color: Colors.red,
                  height: 200.0,
                ),
                new Container(
                  color: Colors.pink,
                  height: 200.0,
                ),
                new Container(
                  color: Colors.lightGreen,
                  height: 200.0,
                ),
                new Container(
                  color: Colors.orange,
                  height: 200.0,
                ),
                new Container(
                  color: Colors.teal,
                  height: 200.0,
                ),
                new Container(
                  color: Colors.purple,
                  height: 200.0,
                ),
                new Container(
                  color: Colors.grey,
                  height: 200.0,
                ),
                new Container(
                  color: Colors.lime,
                  height: 200.0,
                ),
                new Container(
                  color: Colors.indigo,
                  height: 200.0,
                ),
                new Container(
                  color: Colors.yellow,
                  height: 200.0,
                ),
                new Container(
                  color: Colors.green,
                  height: 200.0,
                ),
                new Container(
                  color: Colors.blue,
                  height: 200.0,
                ),
              ],
            ),
          ),
          new ListView.builder(
            controller: _scrollController,
            itemBuilder: buildItem,
            itemCount: 20,
          ),
        ],
      ),
    );
  }

  Widget buildItem(BuildContext context, int index) {
    var mode = index % 4;
    switch (mode) {
      case 0:
        return new Parallax.inside(
          child: new Image.asset(
              'assets/21.png'),
          mainAxisExtent: 150.0,
        );
      case 1:
        return new Parallax.inside(
          child: new Image.asset(
              'assets/22.jpg'),
          mainAxisExtent: 150.0,
          direction: AxisDirection.right,
        );
      case 2:
        return new Parallax.inside(
          child: new Image.asset(
              'assets/21.pngg'),
          mainAxisExtent: 150.0,
          flipDirection: true,
        );
      default:
        return new Parallax.inside(
          child: new Image.asset(
              'assets/22.jpg'),
          mainAxisExtent: 150.0,
          direction: AxisDirection.left,
        );
    }
  }
}
