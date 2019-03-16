import 'package:flutter/material.dart';
var _themeData=new ThemeData(primarySwatch: Colors.red);

void main() => runApp(new MaterialApp(
      theme:_themeData,
      home: new MyApp(),
    ));

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  final usernameController = new TextEditingController();
  var username = "";
  var _themeData=new ThemeData(primarySwatch: Colors.red);
  @override
  Widget build(BuildContext context) {
    return Theme(data: _themeData,
      child: new Scaffold(
        appBar: AppBar(
          leading: new Icon(Icons.home),
         // backgroundColor: Colors.pinkAccent,
          title: new Text("Data"),
          actions: <Widget>[new Icon(Icons.add), new Icon(Icons.star),new Icon(Icons.favorite)],
        ),
        body: Center(
          child: new SingleChildScrollView(
            child: new Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: <Widget>[
                new Image.asset(
                  'assets/images/1.jpg',
                  fit: BoxFit.cover,
                ),
                new TextField(
                  controller: usernameController,
                  onSubmitted: (txt) {
                    setState(() {
                      username = usernameController.text;
                    });
                  },
                ),
                InkWell(
                    onTap: () {
                      setState(() {
                        username = usernameController.text;
                      });
                    },
                    child: new Icon(Icons.edit)),
                new Text("Hello : ${username}")
              ],
            ),
          ),
        ),
      ),
    );
  }
}
