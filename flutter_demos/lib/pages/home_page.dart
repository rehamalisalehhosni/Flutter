import 'package:flutter_demos/fragments/first_fragment.dart';
import 'package:flutter_demos/fragments/second_fragment.dart';
import 'package:flutter_demos/fragments/third_fragment.dart';
import 'package:flutter_demos/fragments/fourth_fragment.dart';
import 'package:flutter_demos/fragments/fifth_fragment.dart';
import 'package:flutter_demos/fragments/six_fragment.dart';
import 'package:flutter_demos/fragments/seven_fragment.dart';
import 'package:flutter_demos/fragments/eight_fragment.dart';
import 'package:flutter_demos/fragments/nine_fragment.dart';
import 'package:flutter_demos/fragments/ten_fragment.dart';
import 'package:flutter_demos/fragments/eleven_fragment.dart';

import 'package:flutter/material.dart';


class DrawerItem {
  String title;
  IconData icon;
  DrawerItem(this.title, this.icon);
}

class HomePage extends StatefulWidget {
  final drawerItems = [
  new DrawerItem("Drag && Drop 1", Icons.rss_feed),
    new DrawerItem("Drag && Drop 2", Icons.local_pizza),
    new DrawerItem("Drag && Drop 3", Icons.info),
    new DrawerItem("Parallex ", Icons.account_balance),
    new DrawerItem("Parallex 2 ", Icons.ac_unit),
    new DrawerItem("Parallex 3 ", Icons.add_location),
    new DrawerItem("Parallex 4 ", Icons.add_location),
    new DrawerItem("Map ", Icons.add_location),
    new DrawerItem("Map View", Icons.add_location),
    new DrawerItem("Map Flutter", Icons.add_location),
    new DrawerItem("Starts ", Icons.add_location)

  ];

  @override
  State<StatefulWidget> createState() {
    return new HomePageState();
  }
}

class HomePageState extends State<HomePage> {
  int _selectedDrawerIndex = 0;

  _getDrawerItemWidget(int pos) {
    switch (pos) {
      case 0:
        return new FirstFragment();
      case 1:
        return new SecondFragment();
      case 2:
        return new ThirdFragment();
      case 3:
        return new ForthFragment();
      case 4:
        return new FifthFragment();
      case 5:
        return new SixFragment();
      case 6:
        return new SevenFragment();
      case 7:
        return new EightFragment();
      case 8:
        return new NineFragment();
      case 9:
        return new TenFragment();
      case 10:
        return new ElevenFragment();

      default:
        return new Text("Error");
    }
  }

  _onSelectItem(int index) {
    setState(() => _selectedDrawerIndex = index);
    Navigator.of(context).pop(); // close the drawer
  }

  @override
  Widget build(BuildContext context) {
    var drawerOptions = <Widget>[];
    for (var i = 0; i < widget.drawerItems.length; i++) {
      var d = widget.drawerItems[i];
      drawerOptions.add(
          new ListTile(
            leading: new Icon(d.icon),
            title: new Text(d.title),
            selected: i == _selectedDrawerIndex,
            onTap: () => _onSelectItem(i),
          )
      );
    }

    return new Scaffold(
      appBar: new AppBar(
        // here we display the title corresponding to the fragment
        // you can instead choose to have a static title
        title: new Text(widget.drawerItems[_selectedDrawerIndex].title),
      ),
      drawer: new Drawer(
        child: new ListView(
          padding: const EdgeInsets.only(top: 0.0),
          children: <Widget>[
            new UserAccountsDrawerHeader(
                accountName: new Text("John Doe"), accountEmail: null),
            new Column(children: drawerOptions)
          ],
        ),
      ),
      body: _getDrawerItemWidget(_selectedDrawerIndex),
    );
  }
}
