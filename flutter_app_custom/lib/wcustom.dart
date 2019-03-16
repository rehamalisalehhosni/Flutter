import 'package:flutter/material.dart';

class customWidget extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return new Container(
      color: Colors.pink,
      child: new Container(
        color: Colors.orange,
        margin: const EdgeInsets.all(15.0),
        child: new Container(
          color: Colors.yellow,
          margin: const EdgeInsets.all(15.0),
          child: new Container(
            color: Colors.greenAccent,
            margin: const EdgeInsets.all(15.0),
            child: new Container(
              color: Colors.lightGreenAccent,
              margin: const EdgeInsets.all(15.0),
              child: new Container(
                color: Colors.deepOrangeAccent,
                margin: const EdgeInsets.all(15.0),
                child: new Container(
                  color: Colors.pinkAccent,
                  margin: const EdgeInsets.all(15.0),
                  child: new Container(
                    color: Colors.purple,
                    margin: const EdgeInsets.all(15.0),
                    child: _methodCustom(),
                  ),
                ),
              ),
            ),
          ),
        ),
      ),
    );
  }
}

Widget _methodCustom() {
  return new Container(
    color: Colors.tealAccent,
    margin: const EdgeInsets.all(15.0),
  );
}
