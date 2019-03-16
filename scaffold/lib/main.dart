import 'package:flutter/material.dart';

void main() {
  runApp(new MaterialApp(
    home: new MyApp(),
  ));
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      backgroundColor: Colors.pinkAccent,
      appBar: new AppBar(
        title: new Text('Demo'),
      ),
      drawer: new Drawer(
        child: new ListView(children: <Widget>[
          new DrawerHeader(child: new Text('Reham')),
          new ListTile(onTap: () {},
            title: new Text("first"),
            subtitle: new Text("dart"),
            leading: new Icon(Icons.copyright),
            trailing: new Switch(value: true, onChanged: null),),
          new ListTile(onTap: () {},
            title: new Text("Second"),
            subtitle: new Text("dart"),
            leading: new Icon(Icons.copyright),
            trailing: new Switch(value: true, onChanged: null),),
          new ListTile(onTap: () {},
            title: new Text("third"),
            subtitle: new Text("dart"),
            leading: new Icon(Icons.copyright),
            trailing: new Switch(value: true, onChanged: null),),
          new ListTile(onTap: () {},
            selected: true,
            title: new Text("fourth"),
            subtitle: new Text("dart"),
            leading: new Icon(Icons.copyright),
            trailing: new Switch(value: true, onChanged: null),),
          new AboutListTile(aboutBoxChildren :< Widget > [new Text('Box')],
              icon: new Icon(Icons.face), child: new Text('about flutter')),
        ],),
      ),endDrawer: new Drawer(
        child: new ListView(children: <Widget>[
          new DrawerHeader(child: new Text('Reham')),
          new ListTile(onTap: () {},
            title: new Text("عربي"),
            subtitle: new Text("dart"),
            leading: new Icon(Icons.copyright),
            trailing: new Switch(value: true, onChanged: null),),
          new ListTile(onTap: () {},
            title: new Text("عربي"),
            subtitle: new Text("dart"),
            leading: new Icon(Icons.copyright),
            trailing: new Switch(value: true, onChanged: null),),
          new ListTile(onTap: () {},
            title: new Text("third"),
            subtitle: new Text("dart"),
            leading: new Icon(Icons.copyright),
            trailing: new Switch(value: true, onChanged: null),),
          new ListTile(onTap: () {},
            selected: true,
            title: new Text("fourth"),
            subtitle: new Text("dart"),
            leading: new Icon(Icons.copyright),
            trailing: new Switch(value: true, onChanged: null),),
          new AboutListTile(aboutBoxChildren :< Widget > [new Text('Box')],
              icon: new Icon(Icons.face), child: new Text('about flutter')),
        ],),
      ),
      floatingActionButton: FloatingActionButton(onPressed: null),
      /*  persistentFooterButtons: <Widget>[
        new FlatButton(onPressed: null, child: new Text("First "),),
        new FlatButton(onPressed: null, child: new Text("First "),),
        new FlatButton(onPressed: null, child: new Text("First "),),
        new FlatButton(onPressed: null, child: new Text("First "),),
      ],*/
      /*    bottomNavigationBar: new BottomNavigationBar(items: <BottomNavigationBarItem>[
        new BottomNavigationBarItem(icon: new Icon(Icons.account_balance),title: new Text('Start')),
        new BottomNavigationBarItem(icon: new Icon(Icons.account_balance),title: new Text('Start')),
        new BottomNavigationBarItem(icon: new Icon(Icons.account_balance),title: new Text('Start')),
      ] ),*/
      body: SingleChildScrollView(
        child: new Column(children: <Widget>[
          Card(child: new Container(height: 160.0)),
          Card(child: new Container(height: 160.0)),
          Card(child: new Container(height: 160.0)),
          Card(child: new Container(height: 160.0)),
          Card(child: new Container(height: 160.0)),
          Card(child: new Container(height: 160.0,
              child: new TextField(controller: new TextEditingController()))),
        ],),
      ),
    );
  }
}
