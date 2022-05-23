package ru.mirea.kovalyov.mireaproject;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import ru.mirea.kovalyov.mireaproject.Story;
import ru.mirea.kovalyov.mireaproject.StoryDAO;

@Database(entities = {Story.class}, version = 1)
public abstract class AppDB extends RoomDatabase {

    public abstract StoryDAO storyDAO();
}