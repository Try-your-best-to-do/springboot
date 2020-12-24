package com.example.springbootdemo.repository;



import com.example.springbootdemo.model.Listener;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListenerRepository extends JpaRepository<Listener,String> {

}
