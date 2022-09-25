import React, { useState, useEffect } from 'react';
import {
  StyleSheet,
  Text,
  TouchableOpacity,
  View
} from 'react-native';

export default function BauCua() {
  const [currentDice, setCurrentDice] = useState('');

  const [items, setItems] = useState(['🐅', '🍷', '🐔', '🦐', '🦀', '🐟']);

  const go = () => {
    //randomize a numnber between 0 and 5, 6 is not included, zero-based index
    let i = Math.floor(Math.random() * 5);
    console.log(i)
    setCurrentDice(items[i]); 
  }

  useEffect(()=> {
    setInterval(()=>setCurrentDice(''), 5000)
  }, [])
 

  return (
    <View style={styles.container}>
    
      <View style={styles.buttonContainer}>
        <TouchableOpacity style={styles.button}>
          <Text style={styles.text}>{items[0]}</Text>
        </TouchableOpacity>
        <TouchableOpacity style={[styles.button, styles.middleButton]}>
          <Text style={styles.text}>{items[1]}</Text>
        </TouchableOpacity>
        <TouchableOpacity style={styles.button}>
          <Text style={styles.text}>{items[2]}</Text>
        </TouchableOpacity>
      </View>

      <View style={styles.buttonContainer}>
        <TouchableOpacity style={styles.button}>
          <Text style={styles.text}>{items[3]}</Text>
        </TouchableOpacity>
        <TouchableOpacity style={[styles.button, styles.middleButton]}>
          <Text style={styles.text}>{items[4]}</Text>
        </TouchableOpacity>
        <TouchableOpacity style={styles.button}>
          <Text style={styles.text}>{items[5]}</Text>
        </TouchableOpacity>
      </View>

      <View style={styles.dice}>
        <TouchableOpacity style={[styles.buttonDice]} onPress={() => go()}>
          <Text style={styles.text}>{currentDice}</Text>
        </TouchableOpacity>
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  dice: {
    justifyContent: 'center',
    alignItems: 'center',
    marginTop: 50,
  },

  container: {
    flex: 1,
    justifyContent: 'center',
    paddingHorizontal: 10,
  },
  text: {
    textAlign: 'center',
    fontSize: 30,
    border: 1,
  },
  buttonContainer: {
    flexDirection: 'row',
    alignItems: 'stretch',
    marginTop: 1,
  },

  button: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    borderWidth: 1,
    borderColor: '#eee',
    padding: 10,
    height: 70,
  },

  buttonDice: {
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#eee',
    padding: 10,
    width: 80,
    height: 80,
  },


  middleButton: {},
});
