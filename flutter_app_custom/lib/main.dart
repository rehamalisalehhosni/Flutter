import 'package:flutter/material.dart';
import 'wcustom.dart';
void main() => runApp(new application());

class application extends StatefulWidget {
  @override
  _applicationState createState() => _applicationState();
}

class _applicationState extends State<application> {
  @override
  Widget build(BuildContext context) {
    return new MaterialApp(
      title: 'home',
      home: new Scaffold(
        body:new customWidget(),
      )
    );
  }
}
