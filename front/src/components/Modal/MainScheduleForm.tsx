import React, { FunctionComponent } from 'react'
import Interface from './interfaces/DayScheduleInput.interface'

const MainScheduleForm: FunctionComponent<Interface> = (props: Interface) => {
  const {
    // date,
    todo,
    goal,
    // handleDate,
    handleTodo,
    handleGoal
  } = props

  return (
    <div className="content">
      {/* <input
        type="date"
        placeholder="날짜를 입력하세요."
        value={date}
        // onChange={handleDate}
      /> <br/> */}
      <input
        type="text"
        placeholder="목표를 입력하세요."
        value={todo}
        onChange={handleTodo}
      />  <br/>
      <input
        type="number"
        placeholder="목표시간을 입력하세요."
        value={goal}
        onChange={handleGoal}
      />
    </div>
  )
}

export default MainScheduleForm