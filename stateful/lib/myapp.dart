import 'package:flutter/material.dart';
import 'dart:math';
import 'package:device_info/device_info.dart';

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {

  getDevicenfo()async{
    DeviceInfoPlugin deviceInfo = DeviceInfoPlugin();
    AndroidDeviceInfo androidInfo = await deviceInfo.androidInfo;
    var brand=androidInfo.brand;
    setState(() {
      info = brand;
    });

  }
  List<String> pl = ["php", "js", "css", "ruby", 'python', 'zend', 'c', 'c#'];

  void getText() {
    setState(() {
      PlText = pl[Random().nextInt(pl.length)];
    });
  }

  void inc() {
    setState(() {
      txtsize++;
       myTxtStyle=TextStyle(fontSize: txtsize);
    });
  }

  String PlText = "";
  String info = "";

  static var txtsize=15.0;
  var myTxtStyle=TextStyle(fontSize: txtsize);
  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      bottomNavigationBar: new BottomAppBar(
        color: Colors.redAccent,
        child: new Container(
          child: new Row(
            mainAxisAlignment: MainAxisAlignment.spaceEvenly,
            children: <Widget>[
              new Text('CopyRight',style: myTxtStyle ),
              new Icon(
                Icons.copyright,
                color: Colors.yellow,
              ),
              new Text('2019',style: myTxtStyle )
            ],
          ),
        ),
      ),
      appBar: AppBar(
        title: new Text('Random'),
      ),
      body: Center(
        child: new Column(
          mainAxisAlignment: MainAxisAlignment.spaceAround,
          children: <Widget>[
            new InkWell(
                onTap: inc,
                child: new Icon(
                  Icons.add,
                  size: 40.0,
                )),
            new Text(PlText,style: myTxtStyle ,),
            new RaisedButton(child: new Text('Click',style: myTxtStyle ), onPressed: getText),
            new RaisedButton(child: new Text('Device',style: myTxtStyle ), onPressed: getDevicenfo),
            new Text(info)

          ],
        ),
      ),
    );
  }
}
