import 'package:flutter/material.dart';
import 'package:whatsapp_ui/models/status_model.dart';

class StatusScreen extends StatefulWidget {
  @override
  StatusScreenState createState() => new StatusScreenState();
}

class StatusScreenState extends State<StatusScreen> {
  Widget _divider( int index) {
    if (index != 0) {
      return new Divider(
        height: 10.0,
      );
    } else {
      return new Container(
        height: 32.0,
        alignment: Alignment.centerLeft,
        padding: new EdgeInsets.only(left: 15.0),
        width: double.maxFinite,
        decoration: BoxDecoration(
          color: new Color(0xffd9d9d9),
        ),
        child: new Text('Recent Updates'),
      );
    }
  }

  @override
  Widget build(BuildContext context) {
    return new ListView.builder(
      itemCount: dummy_data.length,
      itemBuilder: (context, index) => new Column(
            children: <Widget>[
              new ListTile(
                leading: new CircleAvatar(
                  foregroundColor: Theme.of(context).primaryColor,
                  backgroundColor: Colors.grey,
                  backgroundImage: new NetworkImage(dummy_data[index].avatarUrl),
                ),
                title: new Row(
                  mainAxisAlignment: MainAxisAlignment.spaceBetween,
                  children: <Widget>[
                    new Text(dummy_data[index].name,
                        style: new TextStyle(fontWeight: FontWeight.bold)),
                  ],
                ),
                subtitle: new Container(
                  padding: new EdgeInsets.only(top: 5.0),
                  child: new Text(dummy_data[index].details,
                      style: new TextStyle(color: Colors.grey, fontSize: 15.0)),
                ),
              ),
              _divider(index)
            ],
          ),
    );
  }
}
