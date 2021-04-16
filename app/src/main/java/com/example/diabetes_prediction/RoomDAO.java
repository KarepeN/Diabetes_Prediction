package com.example.diabetes_prediction;



import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface RoomDAO {

    @Query("Select * from login where usename = :username")
    public UsernamePassword getUserwithUsername(String username);

    @Query("Select * from login where isloggedIn = 1")
    public UsernamePassword getLoggedInUser();

    @Insert
    public void Insert(Reminders reminders);

    @Update
    public void Update(Reminders... reminders);

    @Delete
    public void Delete(Reminders reminders);


}
