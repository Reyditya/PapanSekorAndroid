package id.owl.com.papansekor

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PapanSekorViewModel : ViewModel() {

    private val sekorA: MutableLiveData<Int>? = MutableLiveData()
    private val sekorB: MutableLiveData<Int>? = MutableLiveData()

    fun plusSekorA() {
        val result: Int? = getSekorA()?.value?.plus(1)
        sekorA?.value = result
    }

    fun plusSekorB() {
        val result: Int? = getSekorB()?.value?.plus(1)
        sekorB?.value = result
    }

    fun minSekorA() {
        val result: Int? = getSekorA()?.value?.minus(1)
        if (result!! < 0) {
            sekorA?.value = 0
        } else {
            sekorA?.value = result
        }
    }

    fun minSekorB() {
        val result: Int? = getSekorB()?.value?.minus(1)
        if (result!! < 0) {
            sekorB?.value = 0
        } else {
            sekorB?.value = result
        }
    }

    fun reset() {
        sekorA?.value = 0
        sekorB?.value = 0
    }

    fun getSekorA(): LiveData<Int>? {
        if (sekorA?.value == null) {
            //Main Thread/UI Thread
            sekorA?.value = 0
        }
        return sekorA
    }

    fun getSekorB(): LiveData<Int>? {
        if (sekorB?.value == null) {
            //Main Thread/UI Thread
            sekorB?.value = 0
        }
        return sekorB
    }
}