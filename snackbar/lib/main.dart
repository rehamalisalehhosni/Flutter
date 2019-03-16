import 'package:flutter/material.dart';

void main() => runApp(new MaterialApp(
      home: new MyApp(),
    ));

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  var scaffoldKey = new GlobalKey<ScaffoldState>();

  showSnackBar() {
    var snackbar = new SnackBar(
      action: new SnackBarAction(label: "Label", onPressed: () {}),
      duration: new Duration(seconds: 30),
      backgroundColor: Colors.pinkAccent,
      content: new Text('Flutter'),
    );
    scaffoldKey.currentState.showSnackBar(snackbar);
  }

  var selectedValue = "ali";
  List<String> users = ["Reham", "Assmaa", "Amany", "Maged","ali"];

  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      key: scaffoldKey,
      appBar: new AppBar(
        title: new Text('sss'),
      ),
      bottomNavigationBar: new BottomAppBar(
        shape: CircularNotchedRectangle(),
        child: new Row(
          mainAxisAlignment: MainAxisAlignment.spaceBetween,
          children: <Widget>[
            IconButton(
              onPressed: () {},
              icon: Icon(Icons.menu),
            ),
          ],
        ),
      ),
      floatingActionButton: FloatingActionButton(onPressed: () {}),
      floatingActionButtonLocation: FloatingActionButtonLocation.endDocked,
      body: Center(
        child: Row(
          crossAxisAlignment: CrossAxisAlignment.center,
          children: <Widget>[
            new Center(
              child: InkWell(
                onTap: () {
                  showSnackBar();
                },
                child: new Text("Click"),
              ),
            ),
            new DropdownButton<String>(
                value: selectedValue,
                items: users.map((user) {
                  return DropdownMenuItem(value: user, child: Text(user));
                }).toList(),
                onChanged: (v) {
                  setState(() {
                    selectedValue = v;
                  });
                }),
          ],
        ),
      ),
    );
  }
}
/*
class MyApp extends StatelessWidget {
  var scaffoldKey = new GlobalKey<ScaffoldState>();

  showSnackBar() {
    var snackbar = new SnackBar(
      action: new SnackBarAction(label: "Label", onPressed: () {}),
      duration: new Duration(seconds: 30),
      backgroundColor: Colors.pinkAccent,
      content: new Text('Flutter'),
    );
    scaffoldKey.currentState.showSnackBar(snackbar);
  }
  var selectedValue="";
  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      key: scaffoldKey,
      appBar: new AppBar(
        title: new Text('sss'),
      ),
      bottomNavigationBar: new BottomAppBar(
        shape: CircularNotchedRectangle(),
        child: new Row(
          mainAxisAlignment: MainAxisAlignment.spaceBetween,
          children: <Widget>[
            IconButton(onPressed: () {}, icon: Icon(Icons.menu),),
          ],
        ),
      ),
      floatingActionButton: FloatingActionButton(onPressed: () {}),
      floatingActionButtonLocation: FloatingActionButtonLocation.endDocked,
      body: Row(
        children: <Widget>[
          new Center(
            child: InkWell(
              onTap: () {
                showSnackBar();
              },
              child: new Text("Click"),
            ),
          ),
          new DropdownButton<String>(value:selectedValue,items: [
            new DropdownMenuItem(value:"ali",child: Text('ali') ),
            new DropdownMenuItem(value:"ali2",child: Text('ali2') ),
            new DropdownMenuItem(value:"ali3",child: Text('ali3') ),
            new DropdownMenuItem(value:"ali4",child: Text('ali4') ),
          ], onChanged: (v){
            setState(() {
              selectedValue=v;
            });

          }),
        ],
      ),
    );
  }
}*/

/*
void main() => runApp(new MaterialApp(
      home: Scaffold(
        body: new MyApp(),
      ),
    ));

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return new Center(
      child: new RaisedButton(onPressed: () {
        var snackbar = new SnackBar(
          action: new SnackBarAction(label: "Label", onPressed: (){}),
          duration: new Duration(seconds: 30),
          backgroundColor: Colors.pinkAccent,
          content: new Text('Flutter'),
        );
        Scaffold.of(context).showSnackBar(snackbar);
      }),
    );
  }
}*/
