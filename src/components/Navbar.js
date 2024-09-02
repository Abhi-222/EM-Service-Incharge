import React from 'react'

const Navbar = () => {
  return (
    <div className="bg-slate-800 h-16 px-10 items-center flex">
    <h1 className="text-3xl font-bold underline">👨🏻‍💻EM Service Incharge</h1>
    <div className="space-x-4 ml-auto ">
      <a className="hover:text-blue-400" href="/">Home</a>
      <a className="hover:text-blue-400" href="/">Profile</a>
      <a className="hover:text-blue-400" href="/">Logout</a>
    </div>
  </div>
  )
}

export default Navbar;