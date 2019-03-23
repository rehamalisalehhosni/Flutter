import 'package:flutter/material.dart';

void main() => runApp(MaterialApp(home: MyApp()));

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
    var mylist= List.generate(500,(i)=>"Fulttwr $i");
    var _controller= ScrollController();
   // var _controller= ScrollController(initialScrollOffset: 50.0);
  @override
  Widget build(BuildContext context) {
    return new Scaffold(
       appBar: AppBar(),
        floatingActionButton: FloatingActionButton(onPressed: (){
          _controller.animateTo(0.0, duration:Duration(seconds:1), curve: Curves.easeInOut );
          //_controller.jumpTo(0.0);
        }),
        body:  Row(
            children: <Widget>[
              Expanded(
                flex:1,
                child: ListView(
                  children: mylist.map((item){
                    return ListTile(
                      leading: FlutterLogo(),
                      title: Text(item),
                    );
                  }).toList(),
                ),
              ),Expanded(
         //             color:Colors.transparent,
                child: ListView(
                  controller: _controller,
                  children: mylist.map((item){
                    return ListTile(
                      leading: FlutterLogo(),
                      title: Text(item),
                    );
                  }).toList(),
                ),
              ),
            ],
          ),
        );
  }
}
