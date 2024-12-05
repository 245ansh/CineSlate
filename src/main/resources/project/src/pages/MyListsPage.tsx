import React, { useState } from 'react';
import { Plus, Film } from 'lucide-react';
import { useAuth } from '../context/AuthContext';
import { MovieList } from '../types';

export const MyListsPage = () => {
  const { user } = useAuth();
  const [showCreateList, setShowCreateList] = useState(false);
  const [newListName, setNewListName] = useState('');

  // Mock lists data - replace with actual data
  const lists: MovieList[] = [
    {
      id: '1',
      name: 'Favorites',
      movies: [
        {
          id: '1',
          title: 'Inception',
          posterUrl: 'https://images.unsplash.com/photo-1440404653325-ab127d49abc1',
          year: 2010,
          rating: 4.8,
          overview: 'A thief who steals corporate secrets...',
        },
      ],
    },
    // Add more lists
  ];

  const handleCreateList = (e: React.FormEvent) => {
    e.preventDefault();
    // Handle list creation
    setShowCreateList(false);
    setNewListName('');
  };

  return (
    <div className="min-h-screen bg-gray-900 pt-20">
      <div className="mx-auto max-w-7xl px-4 py-12">
        <div className="mb-8 flex items-center justify-between">
          <h1 className="text-3xl font-bold text-white">My Lists</h1>
          <button
            onClick={() => setShowCreateList(true)}
            className="flex items-center gap-2 rounded-lg bg-purple-600 px-4 py-2 font-medium text-white hover:bg-purple-700"
          >
            <Plus className="h-5 w-5" />
            Create List
          </button>
        </div>

        {showCreateList && (
          <div className="mb-8 rounded-lg bg-gray-800 p-6">
            <form onSubmit={handleCreateList}>
              <div className="mb-4">
                <label htmlFor="listName" className="mb-2 block text-sm text-gray-300">
                  List Name
                </label>
                <input
                  id="listName"
                  type="text"
                  value={newListName}
                  onChange={(e) => setNewListName(e.target.value)}
                  className="w-full rounded-lg bg-gray-700 px-4 py-2 text-white placeholder-gray-400 focus:outline-none focus:ring-2 focus:ring-purple-500"
                  placeholder="Enter list name"
                  required
                />
              </div>
              <div className="flex gap-4">
                <button
                  type="submit"
                  className="rounded-lg bg-purple-600 px-4 py-2 font-medium text-white hover:bg-purple-700"
                >
                  Create
                </button>
                <button
                  type="button"
                  onClick={() => setShowCreateList(false)}
                  className="rounded-lg bg-gray-700 px-4 py-2 font-medium text-white hover:bg-gray-600"
                >
                  Cancel
                </button>
              </div>
            </form>
          </div>
        )}

        {lists.length > 0 ? (
          <div className="grid grid-cols-1 gap-6 md:grid-cols-2 lg:grid-cols-3">
            {lists.map((list) => (
              <div key={list.id} className="group relative overflow-hidden rounded-lg bg-gray-800">
                <div className="aspect-[2/1] bg-gradient-to-br from-purple-900 to-blue-900">
                  {list.movies[0] && (
                    <img
                      src={list.movies[0].posterUrl}
                      alt={list.name}
                      className="h-full w-full object-cover opacity-50"
                    />
                  )}
                </div>
                <div className="p-4">
                  <h3 className="text-xl font-bold text-white">{list.name}</h3>
                  <div className="mt-2 flex items-center gap-2 text-gray-400">
                    <Film className="h-4 w-4" />
                    <span>{list.movies.length} movies</span>
                  </div>
                </div>
                <div className="absolute inset-0 flex items-center justify-center bg-black/50 opacity-0 transition-opacity group-hover:opacity-100">
                  <button className="rounded-lg bg-purple-600 px-4 py-2 font-medium text-white hover:bg-purple-700">
                    View List
                  </button>
                </div>
              </div>
            ))}
          </div>
        ) : (
          <div className="flex min-h-[400px] items-center justify-center rounded-lg bg-gray-800">
            <div className="text-center">
              <p className="text-xl text-gray-400">You haven't created any lists yet.</p>
              <p className="mt-2 text-gray-500">Start organizing your favorite movies!</p>
            </div>
          </div>
        )}
      </div>
    </div>
  );
};