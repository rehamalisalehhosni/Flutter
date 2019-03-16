import 'package:flutter/material.dart';

void main(){
  runApp(
      new application()
  );
}

class application extends StatefulWidget {
  @override
  _applicationState createState() => _applicationState();
}

class _applicationState extends State<application> {
  List <int> _items=new List();
  @override
  void initState(){
    for(int i=0;i<50;i++){
      _items.add(i);
    }
    super.initState();
  }
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'my app',
      home: new Scaffold(
        appBar: new AppBar(title: new Text('my App'),),
        body: new GridView.builder(
           itemCount: _items.length,
           gridDelegate: new SliverGridDelegateWithFixedCrossAxisCount(crossAxisCount: 4),
           itemBuilder: (BuildContext context, int index){
           return new Card(color: Colors.deepOrange,child: new Padding(padding: const EdgeInsets.all(20.0)));

           },
        )
      ),
    );
  }
}
