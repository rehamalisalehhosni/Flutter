import 'package:flutter/material.dart';

void main() => runApp(new application());

class application extends StatefulWidget {
  @override
  _applicationState createState() => _applicationState();
}

class _applicationState extends State<application> {
  List <int> items=new List();
  @override
  void initState(){
    for(int i=0;i<50;i++){
      items.add(i);
   }
    super.initState();
  }
  Widget build(BuildContext context) {
    return  MaterialApp(
      title:'list',
      home:new Scaffold(
        appBar: new AppBar(title: new Text('title'),),
        body:new ListView.builder(
          itemCount: items.length,
          itemBuilder: (BuildContext context,int index){
            return
              new ListTile(
                title: new Text('test : $index'),
                trailing: new Icon(Icons.ac_unit),
             );
          },
        ),
      ),
    );
  }
}
