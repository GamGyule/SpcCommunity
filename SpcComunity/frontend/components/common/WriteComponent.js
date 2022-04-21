import axios from 'axios'
import { useRouter } from 'next/router';
import { useState } from 'react'
import Editor from '../public/WebEditor'



function WriteComponent() {
    const [data, setData] = useState("");
    return (
        <div>
            <Editor
                name="description"
                onChange={(data) => {
                    setData(data);
                }}
            />
            <div>
                {data}
            </div>
        </div>
    )
}
export default WriteComponent;