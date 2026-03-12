

import React from "react";
import { useState, useEffect } from "react";
import axios from "axios";

const FetchAxios = () => {
  const [posts, setPosts] = useState([]);

  const loadPosts = async () => {
    const response = await axios.get("https://dummyjson.com/posts");
    console.log(response);
    setPosts(response.data.posts);
  };

  const [postData, setPostData] = useState({
    title: "",
    body: "",
    userId:""
  });

  const handlechange = (e) => {
    setPostData({
      ...postData,
      [e.target.name]: e.target.value,
    });
  };

  const handleAddPost = async (e) => {
    e.preventDefault();
    const response = await axios.post(
      "https://dummyjson.com/posts/add",
      postData,
    );
    // console.log(response);
    loadPosts();
  };
  useEffect(() => {
    loadPosts();
  }, []);

  return (
    <>
      <h1>Posts</h1>
      <h2>Add Post</h2>
      <form onSubmit={handleAddPost}>
        <input
          type="text"
          name="userId"
          value={postData.userId}
          placeholder="User ID"
          onChange={handlechange}
        />  
        <input
          type="text"
          name="title"
          value={postData.title}
          placeholder="Title"
          onChange={handlechange}
        />
        <input
          type="text"
          name="body"
          value={postData.body}
          placeholder="Body"
          onChange={handlechange}
        />
        <button type="submit">Add Post</button>
      </form>
      <hr></hr>
      <ul>
        {posts.map((post) => (
          <li key={post.id} style={{ listStyle: "none" }}>
            <h2>{post.title}</h2>
            <p>{post.body}</p>
          </li>
        ))}
      </ul>
    </>
  );
};

export default FetchAxios;