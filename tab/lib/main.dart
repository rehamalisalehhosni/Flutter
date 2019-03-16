import 'package:flutter/material.dart';

void main() => runApp(new MaterialApp(home:MyApp()));

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> with SingleTickerProviderStateMixin{
   TabController tabController;
  @override
  void initState() {
   super.initState();
   tabController=TabController(length: 4, vsync: this);
  }

   @override
   void dispose() {
     tabController.dispose();
    super.dispose();
   }

   @override
  Widget build(BuildContext context) {
    return new Scaffold(
      appBar: AppBar(bottom: TabBar(controller:tabController,tabs: <Widget>[
        Icon(Icons.map),
        Icon(Icons.favorite),
        Icon(Icons.edit),
        Icon(Icons.face),
      ],),),
      body: TabBarView(controller:tabController,children: <Widget>[
        Container(color: Colors.amberAccent,),
        Container(color: Colors.deepPurpleAccent,),
        Container(color: Colors.pinkAccent,),
        Container(color: Colors.red,),
      ],),
    );
  }
}
