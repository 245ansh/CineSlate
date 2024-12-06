import   { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import { Star, Plus, PenSquare } from 'lucide-react';
import axios from "axios";

export const MovieDetails = () => {
  const { id } = useParams();
  const [rating, setRating] = useState(0);
  const [showListDropdown, setShowListDropdown] = useState(false);

  // Initial state with default movie structure
  const [movie, setMovie] = useState({
    id: '',
    title: '',
    posterUrl: '',
    year: null,
    rating: null,
    overview: '',
    director: '',
    cast: [],
  });
  const [error, setError] = useState(null);
  const [loading, setLoading] = useState(true);


  // Replace with actual movie data fetching
  const movie1 = {
    id: '1',
    title: 'Inception',
    posterUrl: 'https://images.unsplash.com/photo-1440404653325-ab127d49abc1',
    year: 2010,
    rating: 4.8,
    overview:
      'A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.',
    director: 'Christopher Nolan',
    cast: ['Leonardo DiCaprio', 'Joseph Gordon-Levitt', 'Ellen Page'],
  };



  useEffect(() => {
    const fetchMovie = async () => {
      try {
        // Fetch movie details using axios
        const response = await axios.get(`http://localhost:8080/movie/${id}`);
        const data = response.data;
        // Update the movie state with the API response
        setMovie({
          id: data.id,
          title: data.title,
          posterUrl: data.posterUrl,
          year: data.year,
          rating: data.rating,
          overview: data.overview,
          director: data.director,
          cast: data.cast,
        });

        setLoading(false); // Mark loading as complete
      } catch (err) {
        setError(err.message); // Capture and set error
        setLoading(false); // Mark loading as complete
      }
    };

    fetchMovie();
  }, [id]);

  return (
    <div className="min-h-screen bg-gray-900 pt-20">
      <div className="relative">
        <div className="absolute inset-0 bg-gradient-to-b from-transparent to-gray-900" />
        <img
          src={movie.posterUrl}
          alt={movie.title}
          className="h-[60vh] w-full object-cover opacity-20"
        />
      </div>

      <div className="relative mx-auto max-w-7xl px-4 py-12">
        <div className="flex flex-col gap-8 lg:flex-row">
          <img
            src={movie.posterUrl}
            alt={movie.title}
            className="h-96 rounded-lg object-cover shadow-2xl lg:h-[500px]"
          />

          <div className="flex flex-col gap-6">
            <div>
              <h1 className="text-4xl font-bold text-white">{movie.title}</h1>
              <p className="mt-2 text-xl text-gray-400">{movie.year}</p>
            </div>

            <div className="flex gap-4">
              <button className="flex items-center gap-2 rounded-full bg-purple-600 px-6 py-3 font-medium text-white hover:bg-purple-700">
                <PenSquare className="h-5 w-5" />
                Write Review
              </button>

              <div className="relative">
                <button
                  onClick={() => setShowListDropdown(!showListDropdown)}
                  className="flex items-center gap-2 rounded-full bg-gray-800 px-6 py-3 font-medium text-white hover:bg-gray-700"
                >
                  <Plus className="h-5 w-5" />
                  Add to List
                </button>

                {showListDropdown && (
                  <div className="absolute right-0 mt-2 w-48 rounded-lg bg-gray-800 py-2 shadow-xl">
                    <button className="w-full px-4 py-2 text-left text-gray-300 hover:bg-gray-700">
                      Watchlist
                    </button>
                    <button className="w-full px-4 py-2 text-left text-gray-300 hover:bg-gray-700">
                      Favorites
                    </button>
                    <button className="w-full px-4 py-2 text-left text-gray-300 hover:bg-gray-700">
                      Create New List
                    </button>
                  </div>
                )}
              </div>
            </div>

            <div className="flex items-center gap-2">
              {[1, 2, 3, 4, 5].map((star) => (
                <button
                  key={star}
                  onClick={() => setRating(star)}
                  className="transition-transform hover:scale-110"
                >
                  <Star
                    className={`h-8 w-8 ${
                      star <= rating ? 'fill-yellow-400 text-yellow-400' : 'text-gray-600'
                    }`}
                  />
                </button>
              ))}
            </div>

            <div>
              <h3 className="mb-2 text-xl font-semibold text-white">Overview</h3>
              <p className="text-gray-300">{movie.overview}</p>
            </div>

            <div>
              <h3 className="mb-2 text-xl font-semibold text-white">Cast</h3>
              <div className="flex flex-wrap gap-2">
                {movie.cast.map((actor) => (
                  <span
                    key={actor}
                    className="rounded-full bg-gray-800 px-4 py-2 text-sm text-gray-300"
                  >
                    {actor}
                  </span>
                ))}
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}