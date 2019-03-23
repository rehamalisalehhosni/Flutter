import 'dart:async';

import 'package:flutter/material.dart';

void main() => runApp(MaterialApp(home: MyApp()));

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  var mylist = List.generate(500, (i) => "Fulttwr $i");
  var _controller = ScrollController();

  // var _controller= ScrollController(initialScrollOffset: 50.0);
  String image1 =
      "https://www.elastic.co/assets/bltada7771f270d08f6/enhanced-buzz-1492-1379411828-15.jpg";
  bool loaded=true;
  final String _fab="fab";
  @override
  Widget build(BuildContext context) {
    return new Scaffold(
        appBar: AppBar(),
        floatingActionButtonLocation: FloatingActionButtonLocation.centerFloat,
        floatingActionButton: FloatingActionButton(
          heroTag: _fab,
          onPressed: (){
          setState((){
            loaded=false;
          });
          Timer(Duration(seconds: 2), (){
            Navigator.push(context, MaterialPageRoute(builder: (BuildContext context ){
              return Hero(
                tag: _fab,
                child: Container(
                  color: Colors.red,
                ),
              );
            }));
            setState((){
              loaded=true;
            });
          });
        },
          backgroundColor: Colors.green,
          child: loaded?new Text('Ok'): CircularProgressIndicator(),
        ),
        body: ListView(
          children: <Widget>[
            ListItem(image1: image1, id: "1"),
            ListItem(image1: 'https://www.w3schools.com/w3css/img_lights.jpg', id: "2"),
            ListItem(image1: 'https://www.w3schools.com/w3css/img_forest.jpg', id: "3"),
            ListItem(image1: 'https://www.w3schools.com/w3css/img_mountains.jpg', id: "4"),
          ],
        ));
  }
}

class ListItem extends StatelessWidget {
  final String image1;
  final String id;
  const ListItem({Key key, this.image1, this.id}) : super(key: key);
  @override
  Widget build(BuildContext context) {
    return ListTile(
      leading: InkWell(
          onTap: () {
            Navigator.push(context,
                MaterialPageRoute(builder: (BuildContext context) {
              return AnotherPage(imageUrl: image1, id: id);
            }));
          },
          child: Hero(
            tag: "text$id",
            child: Container(
              height: 50.0,
              width: 50.0,
              decoration: BoxDecoration(
                  shape: BoxShape.circle,
                  image: DecorationImage(
                      fit: BoxFit.fill, image: NetworkImage(image1))),
            ),
          )),
      title: new Text("data"),
    );
  }
}

class AnotherPage extends StatelessWidget {
  final String imageUrl;
  final String id;

  const AnotherPage({Key key, this.imageUrl, this.id}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: new AppBar(),
      body: Hero(
        tag: 'text$id',
        child: Center(
          child: new Container(
            color: Colors.green,
            child: Image.network(imageUrl),
          ),
        ),
      ),
    );
  }
}
