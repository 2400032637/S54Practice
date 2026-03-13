

import { useState, useEffect } from 'react'

const LocalJson = () => {
    const [data, setData] = useState([]);
    const loadUsers = async () =>{
        const response = await fetch('/users.json');
        const jsonData = await response.json();
        setData(jsonData);
    }
    
    useEffect(() => {
        loadUsers();
    }, [])

  return (
    <div> 
        <h1> Users Data</h1>
        <table border={1} cellPadding={5} cellSpacing={0}>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Age</th>
                    <th>Country</th>
                </tr>
            </thead>
            <tbody>
                {data.map((user) => (
                    <tr key={user.id}>
                        <td>{user.id}</td>
                        <td>{user.name}</td>
                        <td>{user.email}</td>
                        <td>{user.age}</td>
                        <td>{user.country}</td>
                    </tr>
                ))}
            </tbody>
        </table>
    </div>
  )
}

export default LocalJson