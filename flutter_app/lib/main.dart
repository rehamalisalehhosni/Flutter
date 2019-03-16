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

class _applicationState extends State<application> with SingleTickerProviderStateMixin{
  String mtext='';
  TabController _tcontroler;
  @override
  void initState() {
    // TODO: implement initState
    _tcontroler=new TabController(length: 3, vsync: this);
    super.initState();
  }
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'my app',
      home: new Scaffold(
        appBar: new AppBar(
          title: new Text('my bar'),
          backgroundColor: Colors.greenAccent,
          centerTitle: true,
          elevation: 30.0,
          toolbarOpacity: 0.6,
          leading: new Icon(Icons.menu),
          actions: <Widget>[
            new IconButton(icon: new Icon(Icons.ac_unit), onPressed: (){setState(() {
              mtext='this text';
            });}),
            new IconButton(icon: new Icon(Icons.access_time), onPressed: (){setState(() {
              mtext='this text6';
            });}),
          ],
           bottom: new TabBar(
             controller: _tcontroler,
             tabs: <Widget>[
               new Tab(icon:new Icon(Icons.home)),
               new Tab(icon:new Icon(Icons.supervisor_account)),
               new Tab(icon:new Icon(Icons.close)),
             ],
           ),
        ),
        body:new TabBarView(
            controller: _tcontroler,
            children: <Widget>[
              new Center(
                child: new Text('Welcome First tab'),
              ), new Center(
                child: new Text('Welcome Sec tab'),
              ), new Center(
                child: new Text('Welcome Third tab'),
              ),
            ],
        ),
         bottomNavigationBar: new Material(
           color:Colors.green,
           child:  new TabBar(
             controller: _tcontroler,
             tabs: <Widget>[
               new Tab(icon:new Icon(Icons.home)),
               new Tab(icon:new Icon(Icons.supervisor_account)),
               new Tab(icon:new Icon(Icons.close)),
             ],
           ),
         ),
        /*new Center(
          child:new Text(mtext),
        ),*/
      ),
    );
  }
}

/*class application extends StatefulWidget {
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
}*/

//class application extends StatefulWidget {
//  @override
//  _applicationState createState() => _applicationState();
//}
//
//class _applicationState extends State<application> {
//  List <int> items=new List();
//  @override
//  void initState(){
//    for(int i=0;i<50;i++){
//      items.add(i);
//    }
//    super.initState();
//  }
//  Widget build(BuildContext context) {
//    return  MaterialApp(
//      title:'list',
//      home:new Scaffold(
//        appBar: new AppBar(title: new Text('title'),),
//        body:new Stack(
//          alignment: Alignment.center,
//          children: <Widget>[
//            new Card(color: Colors.deepOrange,child: new Padding(padding: const EdgeInsets.all(200.0),)),
//            new Card(color: Colors.green,child: new Padding(padding: const EdgeInsets.all(100.0),)),
//            new Card(color: Colors.pink,child: new Padding(padding: const EdgeInsets.all(50.0),)),
//            new Card(color: Colors.deepPurple,child: new Padding(padding: const EdgeInsets.all(10.0),)),
//          ],
//       ),
//      ),
//    );
//  }
//}

//class application extends StatefulWidget {
//  @override
//  _applicationState createState() => _applicationState();
//}
//
//class _applicationState extends State<application> {
//  List <int> items=new List();
//  @override
//  void initState(){
//    for(int i=0;i<50;i++){
//      items.add(i);
//    }
//    super.initState();
//  }
//  Widget build(BuildContext context) {
//    return  MaterialApp(
//      title:'list',
//      home:new Scaffold(
//        appBar: new AppBar(title: new Text('title'),),
//        body:new ListView.builder(
//          itemCount: items.length,
//          itemBuilder: (BuildContext context,int index){
//            return
//              new ListTile(
//                title: new Text('test : $index'),
//                trailing: new Icon(Icons.ac_unit),
//              );
//          },
//        ),
//      ),
//    );
//  }
//}



//class application extends StatelessWidget {
//  @override
//  Widget build(BuildContext context) {
//    return MaterialApp(
//      title: 'List Items',
//      home: new Scaffold(
//        appBar: new AppBar(title: new Text('list View'),),
//        body: new ListView(
//          children: <Widget>[
//            new ListTile(
//              title: new Text('test 1'),
//              trailing: new Icon(Icons.ac_unit),
//            ), new ListTile(
//              title: new Text('test 1'),
//              trailing: new Icon(Icons.ac_unit),
//            ), new ListTile(
//              title: new Text('test 1'),
//              trailing: new Icon(Icons.ac_unit),
//            ), new ListTile(
//              title: new Text('test 1'),
//              trailing: new Icon(Icons.ac_unit),
//            ), new ListTile(
//              title: new Text('test 1'),
//              trailing: new Icon(Icons.ac_unit),
//            ), new ListTile(
//              title: new Text('test 1'),
//              trailing: new Icon(Icons.ac_unit),
//            ), new ListTile(
//              title: new Text('test 1'),
//              trailing: new Icon(Icons.ac_unit),
//            ), new ListTile(
//              title: new Text('test 1'),
//              trailing: new Icon(Icons.ac_unit),
//            ), new ListTile(
//              title: new Text('test 1'),
//              trailing: new Icon(Icons.ac_unit),
//            ), new ListTile(
//              title: new Text('test 1'),
//              trailing: new Icon(Icons.ac_unit),
//            ), new ListTile(
//              title: new Text('test 1'),
//              trailing: new Icon(Icons.ac_unit),
//            ), new ListTile(
//              title: new Text('test 1'),
//              trailing: new Icon(Icons.ac_unit),
//            ), new ListTile(
//              title: new Text('test 1'),
//              trailing: new Icon(Icons.ac_unit),
//            ),
//          ],
//        ),
//      ),
//    );
//  }
//}

//class application extends StatelessWidget {
//  @override
//  Widget build(BuildContext context) {
//    return MaterialApp(
//      title: 'My App',
//      home: new Scaffold(
//        appBar: new AppBar(title: new Text('Title && row'),),
//        body:new Row(
//          mainAxisAlignment: MainAxisAlignment.center,
//          children: <Widget>[
//            new Text('First'),
//            new Column(
//              mainAxisAlignment: MainAxisAlignment.center,
//              children: <Widget>[
//                new Text('third'),
//                new Text('third'),
//                new Text('third'),
//
//              ],
//            ),
//            new Text('third'),
//          ],
//        )
//      )
//    );
//  }
//}

//class application extends StatelessWidget {
//  @override
//  Widget build(BuildContext context) {
//    return new MaterialApp(
//      title: 'Myapplication',
//      home:new Scaffold(
//        body: new Container(
//         // color:Colors.pink,
//          child: new Text('This Is My Container'),
//          height: 300.0,
//          width: 300.0,
//          alignment: Alignment.center,
//          padding: const EdgeInsets.all(20.0),
//          decoration: new BoxDecoration(
//            color: Colors.green,
//          ),
//       //   transform: Matrix4.rotationZ(0.5),
//          foregroundDecoration: new BoxDecoration(
//            color:Colors.deepOrange,
//          ),
//        ),
//      ),
//    );
//  }
//}

//class application extends StatefulWidget {
//  @override
//  _applicationState createState() => _applicationState();
//}
//
//class _applicationState extends State<application> {
//  String ttext='';
//  int counter=0;
//  @override
//  void initState() {
//    // TODO: implement initState
//    ttext='Click This Button';
//    super.initState();
//  }
//void method1(){
// setState(() {
//   ttext='has been changed';
//   counter++;
// });
//}
//  @override
//  Widget build(BuildContext context) {
//    return new MaterialApp(
//      title:'Widget staatful',
//      home: new Scaffold(
//        body:new Center(
//          child:new RaisedButton(onPressed: (){ method1();},child:new Text(ttext)),
//        ),
//      ),
//    );
//  }
//}

//
//class myApplication extends StatelessWidget {
//  @override
//  Widget build(BuildContext context) {
//    return new MaterialApp(
//      title:'My App',
//      home: Scaffold(
//        body: new Container(
//          color:Colors.pink,
//          child:new Container(
//            color: Colors.amber,
//            margin: EdgeInsets.all(30.0),
//          ),
//        ),
//      ),
//    );
//  }
//
//}
