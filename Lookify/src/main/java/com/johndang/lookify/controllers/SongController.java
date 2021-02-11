package com.johndang.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.johndang.lookify.models.Song;
import com.johndang.lookify.services.SongService;

@Controller
public class SongController {
	
	@Autowired
	private SongService songService;
	
	public SongController(SongService songService) {
		this.songService = songService;
	}
	
	//landing page
		@GetMapping("/")
		public String index() {
			return "index.jsp";
		}
		
		//show song form
		@GetMapping("/songs/new") 
		public String songForm(@ModelAttribute("song") Song song) {
			return "newSong.jsp";
		}	
			
		//place where submitted form info goes to
		@PostMapping("/createSong")
		public String createSong(@Valid @ModelAttribute("song") Song song, BindingResult result) {
				if(result.hasErrors()) {
					return "newSong.jsp";
				}
				songService.save(song);
				return "redirect:/dashboard";
			}
		
		//delete song
		@GetMapping("/songs/delete/{id}")
		public String delete(@PathVariable("id") Long id) {
			songService.delete(id);
			return "redirect:/dashboard";
		}
		
		//show dashboard with all songs from context via Model Attribute and model model
		@GetMapping("/dashboard")
		public String showAllSongs(@ModelAttribute ("song") Song song, Model model) {
			model.addAttribute("allSongs", songService.allSongs());
			return "dashboard.jsp";
		}
		
		//show song detail, needs model model and findbyid
		@GetMapping("/songs/{id}")
		public String showSongDetail(@PathVariable("id") Long id, Model model) {
			Song song = songService.findById(id);
	        model.addAttribute("song", song);
			return "showSong.jsp";
		}
		
		
		//search by artist containing
		@GetMapping("/searchArtist")
		public String search(@RequestParam("search") String search, Model model) {
			List<Song> songs = songService.findByArtist(search);
			model.addAttribute("songs", songs);
			model.addAttribute("search", search);
			return "searchResult.jsp";
		}
		
		//search by top ten
		@GetMapping("/topTen")
		public String topTen(Model model) {
			List<Song> songs = songService.topTenSongs();
			model.addAttribute("songs", songs);
			return "topTenResults.jsp";
		}
		
		
			
		
}
