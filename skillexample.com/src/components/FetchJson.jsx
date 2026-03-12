
import React from 'react'
import { useState, useEffect } from 'react'

const FetchJson = () => {
    const [users, setUsers] = useState([]);
    const loadUsers = async () => {
        const res = await fetch('https://jsonplaceholder.typicode.com/users', {
            method: 'GET'
        });
        const jsonData = await res.json();
        setUsers(jsonData);
    }
    useEffect(() => {
        loadUsers();
    }, [])

  return (
    <>
    <h1> Users Data</h1>
    <table border={1} cellPadding={5} cellSpacing={0}>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Website</th>
            </tr>
        </thead>
        <tbody> 
            {users.map((user) => (
                <tr key={user.id}>
                    <td>{user.id}</td>  
                    <td>{user.name}</td>
                    <td>{user.email}</td>
                    <td>{user.phone}</td>   
                    <td>{user.website}</td>
                </tr>
            ))}
        </tbody>
    </table>
    </>
  )
}

export default FetchJson