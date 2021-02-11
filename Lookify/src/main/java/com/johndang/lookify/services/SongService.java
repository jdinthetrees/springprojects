package com.johndang.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johndang.lookify.models.Song;
import com.johndang.lookify.repositories.SongRepo;



@Service
public class SongService {
	
	@Autowired
	private SongRepo songRepo; 
	
	
	//get all
	public List<Song> allSongs() {
		return songRepo.findAll();
	}
	
	//find by Id
	public Song findById(Long id) {
		Optional<Song> song = songRepo.findById(id);
		if(song.isPresent()) {
			return song.get();
		}else {
			return null;
		}
	}
	
	//create and update
	public Song save(Song song) {
		return songRepo.save(song);
		
	}
	//delete
	public void delete(Long id) {
		songRepo.deleteById(id);
	}
	
	public List<Song> findByArtist(String search) {
		//this is where we really construct our query
		return songRepo.findByArtistContaining(search);
	}
	
	public List<Song> topTenSongs() {
		return songRepo.findTop10ByOrderByRatingDesc();
	}

}