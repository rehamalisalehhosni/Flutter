import 'package:flutter/material.dart';

void main() => runApp(MaterialApp(
      routes: <String,WidgetBuilder>{
        '/Details':(BuildContext context)=>new DetailsPage(),
        '/About':(BuildContext context)=>new AboutPage(),
      },
      home: new MyHomePage(),
    ));

class MyHomePage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      floatingActionButton: new FloatingActionButton(onPressed: () {
        Navigator.pushNamed(context,'/Details');
        /*Navigator.push(context,
            new MaterialPageRoute(builder: (context) => new DetailsPage()));*/
      }),
      appBar: new AppBar(
        title: new Text("HomePage"),
      ),
      body: new Center(
        child: new Text("Home Page"),
      ),
    );
  }
}

class DetailsPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: new AppBar(
        title: new Text("DetailsPage"),
      ),
      body: new Center(
        child: new RaisedButton(onPressed: (){
          Navigator.pushNamed(context,'/About');

/*
          Navigator.push(context,
              new MaterialPageRoute(builder: (context) => new AboutPage()));
*/
        })
      ),
    );
  }
}

class AboutPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: new AppBar(
        title: new Text("About Page"),
      ),
      body: new Center(
        child: new RaisedButton(onPressed: (){
          Navigator.pop(context);
        })
      ),
    );
  }
}
