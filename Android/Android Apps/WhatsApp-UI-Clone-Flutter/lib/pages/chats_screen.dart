import 'package:flutter/material.dart';
import 'package:whatsapp_ui/models/chat_model.dart';

class ChatsScreen extends StatefulWidget{
  @override
  State<StatefulWidget> createState() {
    return new ChatScreenState();
  }
}

class ChatScreenState extends State<ChatsScreen>{
  @override
  Widget build(BuildContext context) {
    return new ListView.builder(
      itemCount: dummy_data.length,
      itemBuilder: (context,i)=> new Column(
        children: <Widget>[
          new Divider(
            height: 10.0,
          ),
          new ListTile(
             leading: new CircleAvatar(
               foregroundColor: Theme.of(context).primaryColor,
               backgroundColor: Colors.grey,
               backgroundImage: new NetworkImage(dummy_data[i].avatarUrl),
             ),
            title: new Row(
              mainAxisAlignment: MainAxisAlignment.spaceBetween,
              children: <Widget>[
                new Text(dummy_data[i].name, style: new TextStyle(fontWeight: FontWeight.bold)),
                new Text(dummy_data[i].time, style: new TextStyle(color: Colors.grey, fontSize: 14.0)),
              ],
            ),
            subtitle: new Container(
              padding: new EdgeInsets.only(top: 5.0),
              child: new Text(dummy_data[i].message, style:new TextStyle(color: Colors.grey,fontSize: 17.0)),
            ),
          )
        ],
      ),
    );
  }

}