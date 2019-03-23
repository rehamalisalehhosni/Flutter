import 'package:flutter/material.dart';

void main() => runApp(MaterialApp(home: MyApp()));

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  var mylist = List.generate(500, (i) => "Fulttwr $i");
  var _controller = ScrollController();

  // var _controller= ScrollController(initialScrollOffset: 50.0);
  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      appBar: AppBar(),
      body: Row(
        children: <Widget>[
          Expanded(
            flex: 1,
            child: ListView(
              children: mylist.map((item) {
                return Dismissible(
                  secondaryBackground: Container(
                    color: Colors.green,
                  ),
                  movementDuration: Duration(seconds: 2),
                  dismissThresholds: {
                    DismissDirection.endToStart: 0.5,
                    DismissDirection.startToEnd: 0.2,
                  },
                  //        direction: DismissDirection.endToStart,
                  background: Container(
                    color: Colors.red,
                    child: Align(
                      alignment: Alignment.centerRight,
                      child: Icon(
                        Icons.delete,
                        color: Colors.white,
                        size: 40.0,
                      ),
                    ),
                  ),
                  onDismissed: (direction) {
                    setState() {
                      mylist.removeAt(mylist.indexOf(item));
                    }
                  },
                  child: ListTile(
                    leading: FlutterLogo(),
                    title: Text(item),
                  ),
                  key: Key(item),
                );
              }).toList(),
            ),
          ),
        ],
      ),
    );
  }
}