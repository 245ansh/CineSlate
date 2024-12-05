import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import { Menu, Film, Search, User, LogIn } from 'lucide-react';

export const Navbar = () => {
  const [isMenuOpen, setIsMenuOpen] = useState(false);
  const isAuthenticated = true; // Replace with actual auth state

  return (
    <nav className="fixed left-0 right-0 top-0 z-50 bg-gray-900/95 backdrop-blur-sm">
      <div className="mx-auto flex max-w-7xl items-center justify-between p-4">
        <div className="relative">
          <button
            onClick={() => setIsMenuOpen(!isMenuOpen)}
            className="rounded-full p-2 text-gray-300 hover:bg-gray-800"
          >
            <Menu className="h-6 w-6" />
          </button>

          {isMenuOpen && (
            <div className="absolute left-0 mt-2 w-48 rounded-lg bg-gray-800 py-2 shadow-xl">
              <Link
                to="/"
                className="flex items-center gap-2 px-4 py-2 text-gray-300 hover:bg-gray-700"
              >
                <Film className="h-4 w-4" />
                Home
              </Link>
              {isAuthenticated ? (
                <>
                  <Link
                    to="/profile"
                    className="flex items-center gap-2 px-4 py-2 text-gray-300 hover:bg-gray-700"
                  >
                    <User className="h-4 w-4" />
                    Profile
                  </Link>
                  <Link
                    to="/my-reviews"
                    className="flex items-center gap-2 px-4 py-2 text-gray-300 hover:bg-gray-700"
                  >
                    Reviews
                  </Link>
                  <Link
                    to="/my-lists"
                    className="flex items-center gap-2 px-4 py-2 text-gray-300 hover:bg-gray-700"
                  >
                    Lists
                  </Link>
                </>
              ) : null}
            </div>
          )}
        </div>

        <Link to="/" className="flex items-center gap-2">
          <Film className="h-8 w-8 text-purple-500" />
          <span className="text-2xl font-bold text-white">CineSlate</span>
        </Link>

        {isAuthenticated ? (
          <Link
            to="/profile"
            className="rounded-full bg-gray-800 p-2 text-gray-300 hover:bg-gray-700"
          >
            <User className="h-6 w-6" />
          </Link>
        ) : (
          <Link
            to="/login"
            className="flex items-center gap-2 rounded-full bg-purple-600 px-4 py-2 font-medium text-white hover:bg-purple-700"
          >
            <LogIn className="h-4 w-4" />
            Login
          </Link>
        )}
      </div>
    </nav>
  );
}