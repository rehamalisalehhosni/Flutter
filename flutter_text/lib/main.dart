import 'package:flutter/material.dart';

void main() => runApp(new application());

class application extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return new MaterialApp(
      title:'my App',
      home:new Column(
        crossAxisAlignment: CrossAxisAlignment.center,
        mainAxisSize: MainAxisSize.min,
        children: <Widget>[
          const Flexible(child: Text('Hew '),),
          new Text('sec'),
          const Expanded(child: const Text("Thrird",textAlign: TextAlign.center,)),
        ],
      )
      );

  }
}
