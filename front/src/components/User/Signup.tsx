import React, { FunctionComponent, useState, ChangeEvent, MouseEvent } from 'react'
import { UserDto } from './interfaces/UserInfo.interface'
import { mainCategoryData } from './dataSet/dataSet'
import SubCategoryGroup from './SubCategoryGroup'
import axios from 'axios'
import path from 'path'
import dotenv from 'dotenv'
import { mainCategory } from './interfaces/DataSet.interface'

dotenv.config({ path: path.join(__dirname, '.env') })

const Signup: FunctionComponent = () => {

    const SERVER_IP = process.env.REACT_APP_TEST_SERVER
    const [ email, setEmail ] = useState<string>('')
    const [ name, setName ] = useState<string>('')
    const [ password, setPassword ] = useState<string>('')
    const user: UserDto = {
        'email': email,
        'name': name,
        'password': password,
    }
    const mainCategoryList: mainCategory[] = mainCategoryData
    
    const handleEmailInputChange = (e: ChangeEvent<HTMLInputElement>) => {
        setEmail(e.target.value)
    }

    const handleNameInputChange = (e: ChangeEvent<HTMLInputElement>) => {
        setName(e.target.value)
    }

    const handlePasswordInputChange = (e: ChangeEvent<HTMLInputElement>) => {
        setPassword(e.target.value)
    }

    const emailCheckHandler = async (e: MouseEvent<HTMLElement>) => {
        e.preventDefault()
        alert(`email 버튼 눌렸다: ${email}`)
        try {
            await axios.get(`${SERVER_IP}/user/checkmail/${email}`)
                    .then(res => alert(`result = ${JSON.stringify(res.data)}`))
        }
        catch(e) {
            alert(e)
        }
    }

    const nameCheckHandler = async (e: MouseEvent<HTMLElement>) => {
        e.preventDefault()
        alert(`name 버튼 눌렸다: ${name}`)
        try {
            await axios.get(`${SERVER_IP}/user/checkname/${name}`)
                    .then(res => alert(`result = ${JSON.stringify(res.data)}`))
        }
        catch(e) {
            alert(e)
        }
    }

    const signupSubmitHandler = async (e: MouseEvent<HTMLElement>) => {
        alert('회원가입 버튼 눌렸다' + JSON.stringify(user))
        try {
            await axios.post(`${SERVER_IP}/user/signup`, user)
                    .then(res => alert(`result = ${JSON.stringify(res.data)}`))
        }
        catch(e) {
            alert(e)
        }
    }

    const mainCategoryCheckHandler = () => {
        console.log('check handler')
    }

    

    return (
        <div>
            <h1>회원가입</h1>
            <form>
                <div>
                    이메일&nbsp;&nbsp;
                    <input type='text' placeholder='이메일' value={email} onChange={handleEmailInputChange}/>
                    <button onClick={emailCheckHandler}>중복체크</button> false가 중복없는것임.
                </div>
                <div>
                    닉네임&nbsp;&nbsp;
                    <input type='text' placeholder='닉네임' value={name} onChange={handleNameInputChange}/>
                    <button onClick={nameCheckHandler}>중복체크</button> false가 중복없는것임.
                </div>
                <div>
                    비밀번호&nbsp;&nbsp;
                    <input type='password' placeholder='비밀번호' value={password} onChange={handlePasswordInputChange}/><br/>
                    비밀번호 확인 &nbsp;&nbsp;
                    <input type='password' placeholder='만들어주세요'/>
                </div>
                {/* <div>
                    <input type='password' placeholder='비밀번호 확인' />
                </div> */}
                <div>
                파일첨부
                </div>
                <div>
                    카테고리 지정<br/> 
                    <div>
                        {/* {mainCategoryList}.map((name, id) => {
                            <div>
                                name
                                <input type='check' key={} onChange={mainCategoryCheckHandler} />
                            </div>
                        }) */}
                    </div>
                    <div>
                        {/* <SubCategoryGroup group={mainCategoryId} /> */}
                    </div>               
                </div>
                <div>
                    <button type='submit' onClick={signupSubmitHandler}>회원가입</button>
                </div>
            </form>
        </div>
    )
}

export default Signup