import 'package:flutter/material.dart';

class op extends StatelessWidget {
  final String mtex;

  op(this.mtex);

  @override
  Widget build(BuildContext context) {
    return new Scaffold(
        appBar: new AppBar(title: new Text(mtex),),
        body: new Center(
          child: new Text(mtex),
        ),
      );
  }
}
