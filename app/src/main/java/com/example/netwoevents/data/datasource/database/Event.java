package com.example.netwoevents.data.datasource.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;


    @Entity(tableName = "events")
    public class Event {
        @PrimaryKey(autoGenerate = true)
        private int id;
        private String title;
        public Event(String title) {
            this.title = title;
        }
        public String getTitle() {
            return title;
        }


        public String getEvent(){
            return title;
        }

        //private int id;

//        private String description;
//
//        private String location;
//
//        private long date;

//        public Event(String title, String description, String location, long date) {
//            this.title = title;
//            this.description = description;
//            this.location = location;
//            this.date = date;
//        }


        public int getId() {
            return id;
        }


//
//        public String getDescription() {
//            return description;
//        }
//
//        public String getLocation() {
//            return location;
//        }
//
//        public long getDate() {
//            return date;
//        }
//
        public void setId(int id) {
            this.id = id;
        }

        public void setTitle(String title) {
            this.title = title;
        }
//
//        public void setDescription(String description) {
//            this.description = description;
//        }
//
//        public void setLocation(String location) {
//            this.location = location;
//        }
//
//        public void setDate(long date) {
//            this.date = date;
//        }
    }




