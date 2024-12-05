import React from 'react';
import { Film, Github, Twitter } from 'lucide-react';
import { Link } from 'react-router-dom';

export const Footer = () => {
  return (
    <footer className="mt-auto bg-gray-900 py-8">
      <div className="mx-auto max-w-7xl px-4">
        <div className="flex flex-col items-center gap-6 md:flex-row md:justify-between">
          <div className="flex items-center gap-2">
            <Film className="h-8 w-8 text-purple-500" />
            <span className="text-2xl font-bold text-white">CineSlate</span>
          </div>
          <div className="flex gap-4">
            <a
              href="https://github.com"
              target="_blank"
              rel="noopener noreferrer"
              className="text-gray-400 hover:text-white"
            >
              <Github className="h-6 w-6" />
            </a>
            <a
              href="https://twitter.com"
              target="_blank"
              rel="noopener noreferrer"
              className="text-gray-400 hover:text-white"
            >
              <Twitter className="h-6 w-6" />
            </a>
          </div>
        </div>
        <div className="mt-8 flex flex-col items-center gap-4 text-sm text-gray-400 md:flex-row md:justify-between">
          <div className="flex gap-4">
            <Link to="/about" className="hover:text-white">
              About
            </Link>
            <Link to="/privacy" className="hover:text-white">
              Privacy
            </Link>
            <Link to="/terms" className="hover:text-white">
              Terms
            </Link>
          </div>
          <p>&copy; {new Date().getFullYear()} CineSlate. All rights reserved.</p>
        </div>
      </div>
    </footer>
  );
}