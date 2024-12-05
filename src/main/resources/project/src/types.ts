export interface Movie {
  id: string;
  title: string;
  posterUrl: string;
  year: number;
  rating: number;
  overview: string;
}

export interface Review {
  id: string;
  movieId: string;
  userId: string;
  rating: number;
  content: string;
  createdAt: string;
  userName: string;
  movieTitle: string;
  moviePoster: string;
}

export interface MovieList {
  id: string;
  name: string;
  movies: Movie[];
}

export interface User {
  id: string;
  name: string;
  email: string;
  reviews: Review[];
  lists: MovieList[];
}